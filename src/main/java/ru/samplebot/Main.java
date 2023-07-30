package ru.samplebot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.samplebot.service.Bot;

/**
 * Чтобы работало необходимо вписать в файле Proprties токен и имя бота!
 */
public class Main {
    public static void main(String[] args) {
        try {//Тут бот регистрируется и запускается
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}