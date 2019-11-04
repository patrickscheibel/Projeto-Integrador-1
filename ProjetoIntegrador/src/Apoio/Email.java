/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apoio;

import Tela.JIFrameEmail;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Scheibel
 */
public class Email {
    
        public void EmailAnexo(String remetente, 
                               String senhas,   
                               String nomeRemetente,
                               String mensagem,
                               String assunto,
                               String destinatario, 
                               String servidorSMTP, 
                               String porta,
                               File[] anexo) {
        try {

            //usuario e senha do seu gmail
            final String usuario = remetente;
            final String senha = senhas;

            //config. do gmail
            Properties mailProps = new Properties();
            mailProps.put("mail.transport.protocol", "smtp");
            mailProps.put("mail.smtp.starttls.enable", "true");
            mailProps.put("mail.smtp.host", servidorSMTP);
            mailProps.put("mail.smtp.auth", "true");
            mailProps.put("mail.smtp.user", usuario);
            mailProps.put("mail.debug", "true");
            mailProps.put("mail.smtp.port", porta);
            mailProps.put("mail.smtp.socketFactory.port", porta);
            mailProps.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            mailProps.put("mail.smtp.socketFactory.fallback", "false");

            //eh necessario autenticar
            Session mailSession = Session.getInstance(mailProps, new Authenticator() {

                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(usuario, senha);
                }
            });
            mailSession.setDebug(false);

            //config. da mensagem
            Message mailMessage = new MimeMessage(mailSession);

            //remetente
            mailMessage.setFrom(new InternetAddress(remetente, nomeRemetente));

            //destinatario
            mailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));

            //mensagem que vai no corpo do email
            MimeBodyPart mbpMensagem = new MimeBodyPart();
            mbpMensagem.setText(mensagem);

//			partes do email
            Multipart mp = new MimeMultipart();
            mp.addBodyPart(mbpMensagem);
            
            String Endereco_Anexo = "";
            if (anexo != null) { // se tiver alguma coisa anexada ela inicializar o comando abaixo
                for (File element : anexo) {

                    Endereco_Anexo = element.getPath();
                    String imagem = Endereco_Anexo;
                    File Arquivo = new File(imagem);
                    //setando o anexo
                    MimeBodyPart mbpAnexo = new MimeBodyPart();
                    mbpAnexo.setDataHandler(new DataHandler(new FileDataSource(Arquivo)));
                    mbpAnexo.setFileName(Arquivo.getName());
                    mp.addBodyPart(mbpAnexo);
                }
            }

            //assunto do email
            mailMessage.setSubject(assunto);

            //seleciona o conteudo 
            mailMessage.setContent(mp);

            //envia o email
            Transport.send(mailMessage);
            JOptionPane.showMessageDialog(null, "Email Enviado com Sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Houve um erro no Envio !\n"+e);
        }
    }


//    public void EmailSimples() throws UnsupportedEncodingException {
//
//        Properties props = new Properties();
//        /** Parâmetros de conexão com servidor Gmail */
//        props.put("mail.smtp.host", ServidorSMTP.getText());
//        props.put("mail.smtp.socketFactory.port", Porta.getText());
//        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.port", Porta.getText());
//
//        Session session = Session.getDefaultInstance(props,
//                new javax.mail.Authenticator() {
//
//                    protected PasswordAuthentication getPasswordAuthentication() {
//                        return new PasswordAuthentication(Remetente.getText(), Senha.getText());
//                    }
//                });
//
//        /** Ativa Debug para sessão */
//        session.setDebug(true);
//
//        try {
//
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(Remetente.getText(), NomeRemetente.getText())); //Remetente
//
//            Address[] toUser = InternetAddress //Destinatário(s)
//                    .parse(Destinatario.getText());
//
//            message.setRecipients(Message.RecipientType.TO, toUser);
//            message.setSubject(Assunto.getText());//Assunto
//            message.setText(Mensagem.getText());
//            /**Método para enviar a mensagem criada*/
//            Transport.send(message);
//
//            System.out.println("Feito!!!");
//            JOptionPane.showMessageDialog(null, "Email Enviado com Sucesso");
//
//        } catch (MessagingException e) {
//            JOptionPane.showMessageDialog(null, "Houve um erro no Envio !");
//            throw new RuntimeException(e);
//
//        }
//    }
        
    public void Anexo(JIFrameEmail jif, String enderecoAnexo){
        JFileChooser file = new JFileChooser();
        file.setMultiSelectionEnabled(true);
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int i = file.showOpenDialog(null);
        if (i == 1) {
            jif.AdicionarAnexo("", null);
        } else {
            File[] Anexo = file.getSelectedFiles();

            String SomaAnexo1 = "";
            String SomaAnexo2 = "";
            for (File enderec : Anexo) {
                SomaAnexo1 = enderec.getPath();
                SomaAnexo2 = SomaAnexo2 + SomaAnexo1 + ";";
//                EnderecoAnexo.setText(SomaAnexo2); 
                jif.AdicionarAnexo(SomaAnexo2, Anexo);
            }
            
        }
    }
    
}
