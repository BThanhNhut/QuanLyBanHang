package utils;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

    public boolean sendEmail(String from, String password, String to, String subject, String content) {
        // Cấu hình thuộc tính
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP HOST
        props.put("mail.smtp.port", "587"); // TLS 587 hoặc SSL 465
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Xác thực người dùng
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        };

        // Tạo một phiên làm việc
        Session session = Session.getInstance(props, auth);

        // Tạo một MimeMessage mới
        MimeMessage msg = new MimeMessage(session);

        try {
            // Đặt kiểu nội dung
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");

            // Đặt người gửi
            msg.setFrom(new InternetAddress(from));

            // Đặt người nhận
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));

            // Đặt tiêu đề email
            msg.setSubject(subject);

            // Đặt ngày gửi
            msg.setSentDate(new Date());

            // Đặt nội dung email
            msg.setContent(content, "text/HTML; charset=UTF-8");

            // Gửi email
            Transport.send(msg);
            System.out.println("Email gửi thành công");
            return true;
        } catch (Exception e) {
            System.out.println("Gặp lỗi khi gửi email");
            e.printStackTrace();
            return false;
        }
    }

}
