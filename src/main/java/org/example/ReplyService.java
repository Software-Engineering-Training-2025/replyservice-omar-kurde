package org.example;

/**
 * Students implement this method to return the exact outputs defined in README.
 */
public class ReplyService {
    private final builder build =  builder.getInstance();

    private final SentencesService sentencesService =  SentencesService.getInstance();
    public String PrepareMessage(String sentence) {
        if (sentence == null) {
            return null;
        }
        return sentence.strip().toLowerCase();
    }
    public String reply(String message, ReplyType type) {
        // TODO: Implement mapping according to README canonical expectations.
        // Requirements:
        // - null or blank -> "Please say something."
        // - For known messages, return exact string for each ReplyType.
        // - For unknown messages, return the 'any other text' mapping.
        message = PrepareMessage(message);
        if (message != null && !message.equals("")) {
            String reply = sentencesService.GetSentence(message, type);
            return reply;
        }

        return "Please say something.";
//        throw new UnsupportedOperationException("Not implemented yet");
    }
}
