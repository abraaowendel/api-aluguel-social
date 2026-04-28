package br.com.api.aluguelsocial.config;

import br.com.api.aluguelsocial.repositories.BeneficiarioRepository;
import br.com.api.aluguelsocial.repositories.ReciboRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"dev","test"})
@RequiredArgsConstructor
public class DataInitializer {
    final BeneficiarioRepository beneficiarioRepository;
    final ReciboRepository reciboRepository;


}
