package ltd.highsoft.frameworks.domain.core;

import lombok.*;

import java.time.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GlobalClock {

    public static final ZoneId DEFAULT_TIME_ZONE = ZoneId.of("Asia/Shanghai");
    private static final ThreadLocal<Clock> CLOCK = new ThreadLocal<>();

    public static Instant now() {
        return CLOCK.get().instant();
    }

    public static ZonedDateTime localNow() {
        return ZonedDateTime.now(CLOCK.get());
    }

    public static ZoneId zone() {
        return clock().getZone();
    }

    static void reset(Clock clock) {
        CLOCK.set(clock);
    }

    static void fixedAt(Instant instant) {
        CLOCK.set(Clock.fixed(instant, DEFAULT_TIME_ZONE));
    }

    static void reset() {
        CLOCK.set(Clock.system(DEFAULT_TIME_ZONE));
    }

    private static Clock clock() {
        return GlobalClock.CLOCK.get();
    }

}
