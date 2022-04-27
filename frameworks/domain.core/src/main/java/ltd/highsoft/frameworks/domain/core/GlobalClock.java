package ltd.highsoft.frameworks.domain.core;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GlobalClock {

    private static final ThreadLocal<Clock> CLOCK = new ThreadLocal<>();

    public static Instant now() {
        return CLOCK.get().instant();
    }

    public static ZonedDateTime localNow() {
        return CLOCK.get().instant().atZone(clock().getZone());
    }

    public static ZoneId zone() {
        return clock().getZone();
    }

    static void fixedAt(Instant instant) {
        CLOCK.set(Clock.fixed(instant, zone()));
    }

    static void reset() {
        CLOCK.set(Clock.system(zone()));
    }

    private static Clock clock() {
        return GlobalClock.CLOCK.get();
    }

}
