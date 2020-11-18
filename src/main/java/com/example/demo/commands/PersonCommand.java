package com.example.demo.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonCommand {
        private Long id;
        private String name;
        private String surname;
}
