package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "MOVEMENT")
@Getter
@Setter
@NoArgsConstructor
public class Movement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String author;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @NotNull
    private Boolean entry;
    @NotBlank
    private String warehouse;
    @NotBlank
    private String warehouseCode;
    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
    @Length(min = 1, max = 1)
    private String customsCode;
    private String customsDocumentReference;
    private String customsDocumentType;
    @NotBlank
    private String type;
    @NotBlank
    private String reference;
    @NotNull
    private Integer quantity;
    @NotNull
    private Integer totalQuantity;
    @NotNull
    private Integer weight;
    @NotNull
    private Integer totalWeight;
    @NotNull
    private String description;

    @AssertTrue(message = "CustomsDocumentRefence and CustomsDocumentType is needed")
    private boolean isExit() {
        if (!this.entry) {
            return ((this.customsDocumentReference != null && !this.customsDocumentReference.trim().isEmpty()) &&
                            (this.customsDocumentType != null && !this.customsDocumentType.trim().isEmpty()));
        }
        return true;
    }

    @AssertTrue(message = "Reference is invalid")
    private boolean isReferenceValid() {
        if (this.type.equalsIgnoreCase("AWB")) {
            return reference.length() == 11;
        }
        return true;
    }

    @AssertTrue(message = "Total quantity must be more or equal than quantity")
    private boolean isQuantityValid() {
        if (this.totalQuantity < this.quantity) {
            return false;
        }
        return true;
    }

    @AssertTrue(message = "Total weight must be more or equal than weight")
    private boolean isWeightValid() {
        if (this.totalWeight < this.weight) {
            return false;
        }
        return true;
    }
}
