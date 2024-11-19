package com.bcc.gestao.bluevelvet.rest.swagger;

import com.bcc.gestao.bluevelvet.model.entity.Product;
import com.bcc.gestao.bluevelvet.model.vo.ProductVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/api/v1")
@Tag(name="Product", description = "Endpoints for mapping products of Blue Velvet Music Store.")
public interface ProductRestControllerSwagger {

    @PostMapping("/products")
    @Operation(summary = "Save one product", tags = {"Product"}, responses = {
            @ApiResponse(description = "Created", responseCode = "201", content = @Content),
            @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Conflict", responseCode = "409", content = @Content)
    })
    public ResponseEntity<Product> save (@RequestBody ProductVO productVO);

    @GetMapping("/products")
    @Operation(summary = "Get list of products by name", tags = {"Product"}, responses = {
            @ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = Product.class))),
            @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Not found", responseCode = "404", content = @Content)
    })
    public ResponseEntity<List<Product>> find(@RequestParam String name);

    @GetMapping("/products/{id}")
    @Operation(summary = "Get one product by id", tags = {"Product"}, responses = {
            @ApiResponse(description = "Success", responseCode = "200", content = @Content),
            @ApiResponse(description = "Not found", responseCode = "404", content = @Content)
    })
    public ResponseEntity<Product> findById(@PathVariable int id);

    @DeleteMapping("/products/{id}")
    @Operation(summary = "Delete one product by id", tags = {"Product"}, responses = {
            @ApiResponse(description = "No content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Not found", responseCode = "404", content = @Content)
    })
    public ResponseEntity<?> delete(@PathVariable int id);

    @PutMapping("/products/{id}")
    @Operation(summary = "Update one product by id", tags = {"Product"}, responses = {
            @ApiResponse(description = "Created", responseCode = "201", content = @Content),
            @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Not found", responseCode = "404", content = @Content)
    })
    public ResponseEntity<Product> update(@PathVariable int id, @RequestBody ProductVO productVO);

    @GetMapping("/products")
    @Operation(summary = "Get a list of all products", tags = {"Product"}, responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Product.class)))})
    })
    public ResponseEntity<List<Product>> findAll();
}
