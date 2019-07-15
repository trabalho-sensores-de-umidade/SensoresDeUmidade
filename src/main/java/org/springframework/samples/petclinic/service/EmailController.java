package org.springframework.samples.petclinic.service;

import javax.mail.internet.MimeMessage;

//import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController{
	
	@Autowired 
	private JavaMailSender mailSender;
	
	@RequestMapping(path = "/email-send", method = RequestMethod.GET)
    public String sendMail() {
        try {
        	MimeMessage mail = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper( mail );
            helper.setTo( "desafiodb2019@gmail.com" );
            helper.setSubject( "Aviso umidade planta: y" );
            helper.setText("<p>O sensor x esta indicando que a umidade da planta y esta fora da faixa ideal</p>"
            		+ "<p>Umidade atual: w% </p><p>Intervalo de umidade ideal : p% - q%</p>", true);
            mailSender.send(mail);
            return "Email enviado com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao enviar email.";
        }
    }
}