package br.com.api.aluguelsocial.services;

import br.com.api.aluguelsocial.repositories.BeneficiarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BeneficiarioService {

    private final BeneficiarioRepository repository;

}

