package teco.li1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class E3 {

    public static void main(String[] args) throws IOException {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String[] s = br.readLine().split("\\|");
            int N = Integer.parseInt(s[0]);
            LocalTime T = LocalTime.parse(s[1]);

            Map<String, Map<String, Map<String, List<Log>>>> map =
                    br.lines().limit(N).map(Log::new)
                            .collect(Collectors.groupingBy(Log::getClientId,
                                    Collectors.groupingBy(Log::getTaskId,
                                            Collectors.groupingBy(Log::getType))));

            Stream.iterate(0, n -> n + 1).limit(10)
                    .map(String::valueOf)
                    .forEach(c -> System.out.println(c + " " + Optional.ofNullable(map.get(c))
                            .map(m -> m.entrySet().stream()
                                    .filter(task -> {
                                        Map<String, List<Log>> log = task.getValue();
                                        return log.get("I").get(0).time.isBefore(T) && log.get("O").get(0).time.isAfter(T);
                                    })
                                    .count())
                            .orElse((long) 0)
                    ));
        }
    }

    static class Log{
        LocalTime time;
        String type;
        String taskId;
        String clientId;

        Log(String log) {
            String[] s = log.split("\\|");
            time = LocalTime.parse(s[0]);
            type = s[1];
            taskId = s[2];
            clientId = s[3];
        }

        public String getType() {
            return type;
        }

        public String getTaskId() {
            return taskId;
        }

        public String getClientId() {
            return clientId;
        }
    }
}
