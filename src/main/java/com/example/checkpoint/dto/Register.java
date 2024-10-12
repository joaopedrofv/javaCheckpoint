package com.example.checkpoint.dto;

import com.example.checkpoint.model.UserRole;

public record Register(String login, String senha, UserRole role)
{
}

