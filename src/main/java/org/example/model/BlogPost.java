package org.example.model;

public record BlogPost(String title, String author, BlogPostType type, int likes) {
}
