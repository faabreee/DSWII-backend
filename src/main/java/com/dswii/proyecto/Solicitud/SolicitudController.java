package com.dswii.proyecto.Solicitud;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dswii.proyecto.Producto.ProductoService;



@RestController
@RequestMapping("/auth/solicitud")
@CrossOrigin(origins ="*" )
public class SolicitudController {
@Autowired
private SolicitudService service;
@Autowired
private ProductoService prodService;

    @PostMapping("/guardar")
    public ResponseEntity<Solicitud> guardarSolicitud(@RequestBody Solicitud s) {
        try {
            // Guarda la solicitud en la base de datos
            Solicitud nuevo = service.guardarSolicitud(s);

            // Devuelve el objeto guardado con estado 200 OK
            return ResponseEntity.status(HttpStatus.OK).body(nuevo);

        } catch (NoSuchElementException e) {
            // Maneja el caso en que no se encuentre el producto relacionado
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        } catch (Exception e) {
            // Maneja otros errores inesperados
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Solicitud> > listarSolicitud(){
    //@RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date date
    return ResponseEntity.ok(service.listarSolicitud());
    }
    /**public JavaMailSender getJavaMailSender() {
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    mailSender.setHost("smtp-mail.outlook.com");
    mailSender.setPort(587);
    mailSender.setUsername("farmastockpe@outlook.com");
    mailSender.setPassword("holamundo01");
    Properties props = mailSender.getJavaMailProperties();
    props.put("mail.transport.protocol", "smtp");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.debug", "true");
    return mailSender;
    }
    public void sendSimpleMessage(String to, String subject, String text) {
    SimpleMailMessage message = new SimpleMailMessage(); 
    message.setFrom("farmastockpe@outlook.com");
    message.setTo(to); 
    message.setSubject(subject); 
    message.setText(text);
    getJavaMailSender().send(message);
    }**/
}
