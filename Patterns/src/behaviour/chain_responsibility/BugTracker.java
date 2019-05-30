package behaviour.chain_responsibility;

public class BugTracker {
    public static void main(String[] args) {
        Notifier reportNotifier = new SimpleReportNotifier(Priority.ROUTINE);
        Notifier emailNotifier = new EmailNotifier(Priority.IMPORTANT);
        Notifier smsNotifier = new SmsNotifier(Priority.ASAP);

        reportNotifier.setNext(emailNotifier);
        emailNotifier.setNext(smsNotifier);

        reportNotifier.notifyManager("YOU LOH",Priority.ASAP);
    }
}
