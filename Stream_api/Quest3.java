package Stream_api;
//убрать вложенный статический класс HashMap2 HashMap2 заменить на анонимный класс метод get переопределить в анонимном классе и решить в одну строку. accept упростить до 1-3 строк
import java.util.*;
import java.util.function.Consumer;

public class Quest3 {
    public static void main(String[] args) {
// Random variables
        String randomFrom = "..."; // Некоторая случайная строка. Можете выбрать ее самостоятельно.
        String randomTo = "...";  // Некоторая случайная строка. Можете выбрать ее самостоятельно.
        int randomSalary = 100;  // Некоторое случайное целое положительное число. Можете выбрать его самостоятельно.

// Создание списка из трех почтовых сообщений.
        MailMessage firstMessage = new MailMessage(
                "Robert Howard",
                "H.P. Lovecraft",
                "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
        );

        assert firstMessage.getFrom().equals("Robert Howard") : "Wrong firstMessage from address";
        assert firstMessage.getTo().equals("H.P. Lovecraft") : "Wrong firstMessage to address";
        assert firstMessage.getContent().endsWith("Howard!") : "Wrong firstMessage content ending";

        MailMessage secondMessage = new MailMessage(
                "Jonathan Nolan",
                "Christopher Nolan",
                "Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!"
        );

        MailMessage thirdMessage = new MailMessage(
                "Stephen Hawking",
                "Christopher Nolan",
                "Я так и не понял Интерстеллар."
        );

        List<MailMessage> messages = Arrays.asList(
                firstMessage, secondMessage, thirdMessage
        );

// Создание почтового сервиса.
        MailService<String> mailService = new MailService<>();
//        System.out.println(messages.get(1).content);
//        System.out.println(messages.get(2).content);
//        System.out.println(messages.get(0).content);
// Обработка списка писем почтовым сервисом
        messages.stream().forEachOrdered(mailService);

//        System.out.println(messages.get(1).content);
//        System.out.println(messages.get(2).content);
//        System.out.println(messages.get(0).content);

// Получение и проверка словаря "почтового ящика",
//   где по получателю можно получить список сообщений, которые были ему отправлены
        Map<String, List<String>> mailBox = mailService.getMailBox();
        System.out.println(
                mailBox.get("H.P. Lovecraft").equals(
                        Arrays.asList(
                                "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
                        )
                )

        );
        System.out.println(" вот тут метод get mailBox");
        System.out.println( mailBox.get("H.P. Lovecraft")
         );
        System.out.println(" вот тут метод get mailBox Для Нолана ");
        System.out.println( mailBox.get("Christopher Nolan")
         );

        assert mailBox.get(randomTo).equals(Collections.<String>emptyList()) : "wrong mailService mailbox content (3)";


// Создание списка из трех зарплат.
        Salary salary1 = new Salary("Facebook", "Mark Zuckerberg", 1);
        Salary salary2 = new Salary("FC Barcelona", "Lionel Messi", Integer.MAX_VALUE);
        Salary salary3 = new Salary(randomFrom, "Mark Zuckerberg", randomSalary);

// Создание почтового сервиса, обрабатывающего зарплаты.
        MailService<Integer> salaryService = new MailService<>();

// Обработка списка зарплат почтовым сервисом
        Arrays.asList(salary1, salary2, salary3).forEach(salaryService);

// Получение и проверка словаря "почтового ящика",
//   где по получателю можно получить список зарплат, которые были ему отправлены.
        Map<String, List<Integer>> salaries = salaryService.getMailBox();
        System.out.println(
                salaries.get(salary1.getTo()).equals(Arrays.asList(1, 100))
        );
        System.out.println(
                salaries.get(salary2.getTo()).equals(Arrays.asList(Integer.MAX_VALUE))
        );
        System.out.println(
                salaries.get(randomTo).equals(Arrays.asList(randomSalary))
        );


//        assert salaries.get(salary1.getTo()).equals(Arrays.asList(1)) : "wrong salaries mailbox content (1)";
//        assert salaries.get(salary2.getTo()).equals(Arrays.asList(Integer.MAX_VALUE)) : "wrong salaries mailbox content (2)";
//        assert salaries.get(randomTo).equals(Arrays.asList(randomSalary)) : "wrong salaries mailbox content (3)";
    }


    public static class Salary implements Sendable<Integer> {
        private String from, to;
        private Integer content;

        public Salary(String from, String to, Integer content) {
            this.from = from;
            this.to = to;
            this.content = content;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public Integer getContent() {
            return content;
        }



    }

    public static class MailService<T> implements Consumer<Sendable<T>> {
        public MailService() {
            mailBox = new HashMap<String, List<T>>() {
                @Override
                public List<T> get(Object key) {
                    return super.get(key) != null ? super.get(key) : Collections.emptyList();
                }
            };
        }
        private Map<String, List<T>> mailBox;

//        private static class HashMap2<K, V> extends HashMap<K, V> {
//            @Override
//            public V get(Object key) {
//                V temp = super.get(key);
//                try {
//                    if (temp == null) {
//                        temp = (V) Collections.emptyList();
//                    }
//                } catch (ClassCastException e) {
//                }
//                return temp;
//            }
//        }

    @Override
    public void accept(Sendable<T> t) {
        mailBox.computeIfAbsent(t.getTo(), k -> new LinkedList<>()).add(t.getContent());
    }

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

// implement here
    }

    public static interface Sendable<T> {
        String getFrom();
        String getTo();
        T getContent();
    }

    public static class MailMessage implements Sendable<String> {
        private String from, to;
        private String content;

        public MailMessage(String from, String to, String content) {
            this.from = from;
            this.to = to;
            this.content = content;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public String getContent() {
            return content;
        }
    }
}


