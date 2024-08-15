package com.ms.user.controller.docs;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.ms.user.dto.UserDto;
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
    public ResponseEntity<UserEntity> createUser(@RequestBody UserDto userDto);

    @Operation(summary="Get user by id", description="This operation is for retrieving a user by its id")
    @ApiResponses(
        value={
            @ApiResponse(
                responseCode="200",
                description="User found",
                content=@Content(mediaType=MediaType.APPLICATION_JSON_VALUE)
            ),
            @ApiResponse(
                responseCode="404",
                description="User not found",
                content=@Content(mediaType=MediaType.APPLICATION_JSON_VALUE)
            ),
            @ApiResponse(
                responseCode="400",
                description="Bad request",
                content=@Content(mediaType=MediaType.APPLICATION_JSON_VALUE)
            ),
            @ApiResponse(
                responseCode="500",
                description="Internal Server Error",
                content=@Content(mediaType=MediaType.APPLICATION_JSON_VALUE)
            )
        }
    )
    public ResponseEntity<UserEntity> getUser(@PathVariable String id);
    
    @Operation(summary="Delete user by id", description="This operation is for removing a user by its id")
    @ApiResponses(
        value={
            @ApiResponse(
                responseCode="200",
                description="User deleted",
                content=@Content(mediaType=MediaType.APPLICATION_JSON_VALUE)
            ),
            @ApiResponse(
                responseCode="404",
                description="User not found",
                content=@Content(mediaType=MediaType.APPLICATION_JSON_VALUE)
            ),
            @ApiResponse(
                responseCode="400",
                description="Bad request",
                content=@Content(mediaType=MediaType.APPLICATION_JSON_VALUE)
            ),
            @ApiResponse(
                responseCode="500",
                description="Internal Server Error",
                content=@Content(mediaType=MediaType.APPLICATION_JSON_VALUE)
            )
        }
    )
    public ResponseEntity<UserEntity> deleteUser(@PathVariable String id);
    
    @Operation(summary="Update user by id", description="This operation is for updating a user by its id")
    @ApiResponses(
        value={
            @ApiResponse(
                responseCode="200",
                description="User updated",
                content=@Content(mediaType=MediaType.APPLICATION_JSON_VALUE)
            ),
            @ApiResponse(
                responseCode="404",
                description="User not found",
                content=@Content(mediaType=MediaType.APPLICATION_JSON_VALUE)
            ),
            @ApiResponse(
                responseCode="400",
                description="Bad request",
                content=@Content(mediaType=MediaType.APPLICATION_JSON_VALUE)
            ),
            @ApiResponse(
                responseCode="500",
                description="Internal Server Error",
                content=@Content(mediaType=MediaType.APPLICATION_JSON_VALUE)
            )
        }
    )
    public ResponseEntity<UserEntity> updateUser(@PathVariable String id, UserEntity newUser);

}
