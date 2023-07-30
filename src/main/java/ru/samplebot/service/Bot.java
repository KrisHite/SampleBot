package ru.samplebot.service;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot implements Properties{
    @Override
    public void onUpdateReceived(Update update) {//Тут реакция на сообщения и ответ
        if(update.hasMessage() && update.getMessage().hasText()){//Тут проверяется наличие сообщения и текста в нем
            SendMessage outMsg = new SendMessage();//Создаю объект с сообщением для отправки
            outMsg.setChatId(update.getMessage().getChatId());//Устанавливаю Idчата которому хочу отправить
            outMsg.setText(update.getMessage().getText());//Устанавливаю текст который отправлю
            try{
                execute(outMsg);//Отправляю текст
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
