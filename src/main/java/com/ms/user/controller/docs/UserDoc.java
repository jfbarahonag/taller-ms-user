package com.ms.user.controller.docs;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.ms.user.model.UserEntity;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="User controller", description="API exposed for CRUD operations on users")
public interface UserDoc {
    
    @Operation(summary="Create a new user", description="This operation is for creating a new user")
    @ApiResponses(
        value={
            @ApiResponse(
                responseCode="201",
                description="User created",
                content=@Content(mediaType=MediaType.APPLICATION_JSON_VALUE)
            ),
            @ApiResponse(
                responseCode="500",
                description="Internal Server Error",
                content=@Content(mediaType=MediaType.APPLICATION_JSON_VALUE)
            )
        }
    )
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity);

}
