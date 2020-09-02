package homework.enums;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeSet;
import lombok.Getter;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.google.common.collect.RangeSet;

@Getter
class Interval {
    private String name;
    private int min;
    private int max;
}

@Getter
class Intervals {
    private List<Interval> intervalList;
}

// Guava Ranges in beta
@SuppressWarnings("UnstableApiUsage")
public class HttpCodeProcessor {
    private static final RangeSet<Integer> rangeSet = TreeRangeSet.create();

    static {
        URL settings = Thread.currentThread()
                .getContextClassLoader()
                .getResource("httpCodeProcessor.json");

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Intervals intervals = objectMapper.readValue(settings, Intervals.class);
            for (Interval interval: intervals.getIntervalList()) {
                Range<Integer> range = Range.closed(interval.getMin(), interval.getMax());
                if (rangeSet.intersects(range)) {
                    throw new RuntimeException("Interval intersection detected");
                }

                rangeSet.add(Range.closed(interval.getMin(), interval.getMax()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BusinessLogic getBusinessLogicForCode(int code) {
        return null;
    }
}
