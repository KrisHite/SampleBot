package ru.samplebot.service;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot implements Properties{
    @Override
    public void onUpdateReceived(Update update) {//Тут реакция на сообщения и ответ
        if(update.hasMessage() && update.getMessage().hasText()){
            SendMessage outMsg = new SendMessage();
            outMsg.setChatId(update.getMessage().getChatId());
            outMsg.setText(update.getMessage().getText());
            try{
                execute(outMsg);
            }catch(TelegramApiException e){
                e.getMessage();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }
    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }
}
