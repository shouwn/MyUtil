package teco.la;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class E4 {

    public static void main(String[] args) throws IOException {
        try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int n = Integer.parseInt(br.readLine());

            Map<String, String> data = new HashMap<>(); // key userId, value data

            for (int i = 0; i < n; i++) {
                final StringTokenizer tokenizer = new StringTokenizer(br.readLine());
                String method = tokenizer.nextToken();
                String url = tokenizer.nextToken();
                String body = null;
                if (tokenizer.hasMoreTokens()) {
                    body = tokenizer.nextToken();
                }

                String[] urls = url.split("/");

//                System.out.println(Arrays.toString(urls));

                StringBuilder sb = new StringBuilder();

                if(urls.length < 3 || urls.length > 4){
                    System.out.println("404 NOT_FOUND");
                    continue;
                }

                if(!"users".equals(urls[1])){
                    System.out.println("404 NOT_FOUND");
                    continue;
                }

                if(urls.length == 4 && !"data".equals(urls[3])){
                    System.out.println("404 NOT_FOUND");
                    continue;
                }

                switch(method){
                    case "POST":
                        if(urls.length == 4){ // 사용자 데이터 저장 API
                            if(!data.containsKey(urls[2]))
                                sb.append("403 FORBIDDEN");
                            else if(body == null)
                                sb.append("405 METHOD_NOT_ALLOWED");
                            else{
                                data.put(urls[2], body.substring(6));
                                sb.append("200 OK");
                            }
                        }
//                        else if("GET".equals(urls[0])) // 사용자 생성 API 예외 POST가 아닌 GET
//                            sb.append("405 METHOD_NOT_ALLOWED");
                        else{
                            if(data.containsKey(urls[2])) // 사용자 생성 API 예외 이미 있는 아이디
                                sb.append("403 FORBIDDEN");
                            else {
                                data.put(urls[2], null); // 사용자 생성 API 성공
                                sb.append("201 CREATED");
                            }
                        }
                        break;
                    case "GET":
                        if(urls.length != 4 || body != null)
                            sb.append("405 METHOD_NOT_ALLOWED");
                        else if(!data.containsKey(urls[2]))
                            sb.append("403 FORBIDDEN");
                        else {
                            String userData = data.get(urls[2]);

                            if(userData == null)
                                sb.append("404 NOT_FOUND");
                            else
                                sb.append("200 OK ").append(userData);
                        }
                        break;
                }

                System.out.println(sb.toString());
            }
        }
    }
}
