package textanalystics.ascencio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import textanalystics.ascencio.model.Sentimiento;
import textanalystics.ascencio.service.SentimientoService;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("api/v1")
public class TextAnalyticsController {

    @Autowired
    private SentimientoService sentimientoService;

    @PostMapping("/sentimiento")
    public ResponseEntity<?> AnalizarSentimiento(@RequestBody() Sentimiento sentimiento) {
        Map<String, String> response= new HashMap<>();
        response.put("Texto", sentimiento.getTexto());
        response.put("Tipo", sentimientoService.analizarSentimiento(sentimiento));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/detectar-lenguaje")
    public ResponseEntity<?> detectarLenguaje(@RequestBody() Sentimiento sentimiento) {
        Map<String, String> response= new HashMap<>();
        response.put("Lenguaje", sentimientoService.detectarLenguaje(sentimiento));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
