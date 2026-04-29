package br.com.api.aluguelsocial.controllers;

import br.com.api.aluguelsocial.model.dto.BeneficiarioRequestDTO;
import br.com.api.aluguelsocial.model.dto.BeneficiarioResponseDTO;
import br.com.api.aluguelsocial.model.dto.PageResponse;
import br.com.api.aluguelsocial.model.enums.Status;
import br.com.api.aluguelsocial.services.BeneficiarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/beneficiarios")
public class BeneficiarioController {


    private final BeneficiarioService beneficiarioService;

    @GetMapping
    public ResponseEntity<PageResponse<BeneficiarioResponseDTO>> listarBeneficiariosPaginados(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String cpf,
            @RequestParam(required = false) Status status,
            Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).
                body(beneficiarioService.listarBeneficiariosPaginados(nome, cpf, status, pageable));
    };

    @GetMapping("/{id}")
    public ResponseEntity<BeneficiarioResponseDTO> listarBeneficiarioPorId(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(beneficiarioService.listarBeneficiarioPorId(id));
    };

    @PostMapping
    public ResponseEntity<Void> cadastrarBeneficiario(@RequestBody @Valid BeneficiarioRequestDTO dto) {
        beneficiarioService.cadastrarBeneficiario(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarBeneficiario(@PathVariable UUID id, @RequestBody BeneficiarioRequestDTO dto) {
        beneficiarioService.atualizarBeneficiario(id, dto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("/status/{id}")
    public ResponseEntity<Void> atualizarStatusBeneficiario(@PathVariable UUID id, @RequestBody Status status) {
        beneficiarioService.atualizarStatusBeneficiario(id, status);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
