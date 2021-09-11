package br.com.carolina.venturahr_candidatura.controller;

import br.com.carolina.venturahr_candidatura.model.service.ProficienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/candidaturas")
public class ProficienciaController {
    @Autowired
    private ProficienciaService proficienciaService;
}
