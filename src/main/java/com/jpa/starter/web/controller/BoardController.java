package com.jpa.starter.web.controller;

import com.jpa.starter.application.service.BoardApplicationService;
import com.jpa.starter.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RequiredArgsConstructor
@RequestMapping("/boards")
@RestController
public class BoardController {

    private final BoardApplicationService boardApplicationService;

    @PostMapping
    public ResponseEntity<UniqueCodeResponse> save(@RequestBody @Validated BoardSaveRequest dto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.boardApplicationService.saveBoard(dto));
    }

    @PatchMapping("/{code}")
    public ResponseEntity<UniqueCodeResponse> update(@PathVariable String code, @RequestBody BoardInfoUpdateRequest dto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.boardApplicationService.updateBoard(code, dto));
    }

    @PatchMapping("/{code}/status")
    public ResponseEntity<UniqueCodeResponse> update(@PathVariable String code, @RequestBody BoardStatusUpdateRequest dto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.boardApplicationService.updateBoard(code, dto));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> delete(@PathVariable String code) {
        this.boardApplicationService.deleteBoard(code);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    @GetMapping
    public ResponseEntity<?> list(@ModelAttribute SearchBoardListRequest dto, @PageableDefault Pageable pageable) {
        return null;
    }

    @GetMapping("{code}")
    public ResponseEntity<BoardInfoResponse> info(@PathVariable String code) {
        BoardInfoResponse response = this.boardApplicationService.getBoard(code);
        if (Objects.isNull(response)) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(response);
        }
    }
}
