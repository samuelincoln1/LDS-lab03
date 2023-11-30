package br.com.xavecoding.regescweb.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void enviarEmail(String destinatario, int moedas) throws jakarta.mail.MessagingException {
        jakarta.mail.internet.MimeMessage mensagem = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mensagem);

        try {
            helper.setTo(destinatario);

            String assunto = "Moedas ganhas";
            helper.setSubject(assunto);
            
            String corpo = "Você recebeu " + moedas + " moedas no sistema!";
            helper.setText(corpo, false);

            javaMailSender.send(mensagem);
        } catch (MailException e) {
            e.printStackTrace(); 
        }
    }

       public void enviarEmailProfessor(String destinatario, int moedas, String aluno) throws jakarta.mail.MessagingException {
        jakarta.mail.internet.MimeMessage mensagem = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mensagem);

        try {
            helper.setTo(destinatario);

            String assunto = "Distribuição de Moedas";
            helper.setSubject(assunto);
            
            String corpo = "Você enviou " + moedas + " moedas para o aluno " + aluno;
            helper.setText(corpo, false);

            javaMailSender.send(mensagem);
        } catch (MailException e) {
            e.printStackTrace(); 
        }
    }

        public void enviarEmailCupom(String destinatario, String cupom) throws jakarta.mail.MessagingException {
        jakarta.mail.internet.MimeMessage mensagem = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mensagem);

        try {
            helper.setTo(destinatario);

            String assunto = "RESGATE CUPOM";
            helper.setSubject(assunto);
            
            String corpo = "Você resgatou um cupom de " + cupom + "!  CODIGO = 3231242131";
            helper.setText(corpo, false);

            javaMailSender.send(mensagem);
        } catch (MailException e) {
            e.printStackTrace(); 
        }
    }
}
