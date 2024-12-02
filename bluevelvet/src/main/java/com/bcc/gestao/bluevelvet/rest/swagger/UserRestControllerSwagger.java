package com.bcc.gestao.bluevelvet.rest.swagger;

import com.bcc.gestao.bluevelvet.model.entity.Product;
import com.bcc.gestao.bluevelvet.model.entity.User;
import com.bcc.gestao.bluevelvet.model.vo.ProductVO;
import com.bcc.gestao.bluevelvet.model.vo.UserVO;
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

import java.util.List;

@RequestMapping("/api/v1")
@Tag(name="User", description = "Endpoints for mapping users of Blue Velvet Music Store.")
public interface UserRestControllerSwagger {

    @PostMapping("/users")
    @Operation(summary = "Save one user", tags = {"User"}, responses = {
            @ApiResponse(description = "Created", responseCode = "201", content = @Content),
            @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Conflict", responseCode = "409", content = @Content)
    })
    public ResponseEntity<UserVO> save(@RequestBody UserVO userVO);

    @GetMapping("/users/{id}")
    @Operation(summary = "Get one user by id", tags = {"User"}, responses = {
            @ApiResponse(description = "Success", responseCode = "200", content = @Content),
            @ApiResponse(description = "Not found", responseCode = "404", content = @Content)
    })
    public ResponseEntity<UserVO> findById(@PathVariable int id);

    @DeleteMapping("/users/{id}")
    @Operation(summary = "Delete one user by id", tags = {"User"}, responses = {
            @ApiResponse(description = "No content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Not found", responseCode = "404", content = @Content)
    })
    public ResponseEntity<?> delete(@PathVariable int id);

    @PutMapping("/users/{id}")
    @Operation(summary = "Update one user by id", tags = {"User"}, responses = {
            @ApiResponse(description = "Created", responseCode = "201", content = @Content),
            @ApiResponse(description = "Bad request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Not found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Conflict", responseCode = "409", content = @Content)
    })
    public ResponseEntity<UserVO> updateUser(@PathVariable int id, @RequestBody UserVO userVO);

    @GetMapping("/users")
    @Operation(summary = "Get a list of all users", tags = {"User"}, responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = UserVO.class)))})
    })
    public ResponseEntity<List<UserVO>> findAll();
}
