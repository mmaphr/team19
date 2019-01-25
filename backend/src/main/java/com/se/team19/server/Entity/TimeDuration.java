package com.se.team19.server.Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@Table
public class TimeDuration {
    @Id
    @GeneratedValue(generator="TimeDuration_Seq")
    private @NonNull Long timeId;
    private @NonNull String timeDuration;

    public TimeDuration(@NonNull String timeDuration) {
        this.timeDuration = timeDuration;
    }
}

