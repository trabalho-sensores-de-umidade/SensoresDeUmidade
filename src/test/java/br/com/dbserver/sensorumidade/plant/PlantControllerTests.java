/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.com.dbserver.sensorumidade.plant;

import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import br.com.dbserver.sensorumidade.plant.Plant;
import br.com.dbserver.sensorumidade.plant.PlantController;
import br.com.dbserver.sensorumidade.plant.PlantRepository;
import br.com.dbserver.sensorumidade.plant.PlantType;
//OLHAR
import org.springframework.samples.petclinic.owner.PetTypeFormatter;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Test class for the {@link PetController}
 *
 * @author Colin But
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = PlantController.class,
    includeFilters = @ComponentScan.Filter(
                            value = PetTypeFormatter.class,
                            type = FilterType.ASSIGNABLE_TYPE))
@WithMockUser(roles = "OWNER_ADMIN")
public class PlantControllerTests {

    private static final int TEST_OWNER_ID = 1;
    private static final int TEST_PET_ID = 1;


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlantRepository pets;


    @Before
    public void setup() {
        PlantType flower = new PlantType();
        flower.setId(3);
        flower.setName("Violets");
        given(this.pets.findPlantTypes()).willReturn(Lists.newArrayList(flower));
        given(this.pets.findById(TEST_PET_ID)).willReturn(new Plant());

    }

    @Test
    public void testInitCreationForm() throws Exception {
        mockMvc.perform(get("/owners/{ownerId}/pets/new", TEST_OWNER_ID))
            .andExpect(status().isOk())
            .andExpect(view().name("pets/createOrUpdatePetForm"))
            .andExpect(model().attributeExists("plant"));
    }

    @Test
    public void testProcessCreationFormSuccess() throws Exception {
        mockMvc.perform(post("/owners/{ownerId}/plants/new", TEST_OWNER_ID)
            .param("name", "Betty")
            .param("type", "hamster")
            .param("birthDate", "2015-02-12")
            .with(csrf()))
            .andExpect(status().is3xxRedirection())
            .andExpect(view().name("redirect:/owners/{ownerId}"));
    }

    @Test
    public void testProcessCreationFormHasErrors() throws Exception {
        mockMvc.perform(post("/owners/{ownerId}/plants/new", TEST_OWNER_ID)
            .param("name", "Betty")
            .param("birthDate", "2015-02-12")
            .with(csrf()))
            .andExpect(model().attributeHasNoErrors("owner"))
            .andExpect(model().attributeHasErrors("plant"))
            .andExpect(model().attributeHasFieldErrors("plant", "type"))
            .andExpect(model().attributeHasFieldErrorCode("plant", "type", "required"))
            .andExpect(status().isOk())
            .andExpect(view().name("plants/createOrUpdatePetForm"));
    }


}
