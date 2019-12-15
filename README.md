[![Build status](https://ci.appveyor.com/api/projects/status/a7p58fdmwr38i528?svg=true)](https://ci.appveyor.com/project/Alexander43884/patternstask)


## Автоматический тест формы "Карта с доставкой!"
(проверка визуализации скрытых форм)
___

* Создать папку, открыть терминал по адресу папки и инициализировать систему Git `git init`
* Склонировать репозиторий `git clone https://github.com/AlexanderKachalov/PatternsTask.git`
* Перейти в директорию artifacts `cd artifacts` и выполнить команду `java -jar app-card-delivery-next.jar`
* Форма заявки находится по адресу `localhost:9999`
* Вернуться в директорию с проектом `cd /PatternsTusk`
* Выполнить команду `./gradlew test` (`./gradlew.bat test` для Windows)
* Отчет о выполнении тестов в директории `build/reports/tests/test`
___
* Тестируемая форма (1) и отображение скрытых форм (2 и 3) при запланировании даты встречи и перепланировании даты:
---
            1 - тестирумая форма
![](pictures/order.png)

---
            2 - отображение 1-й скрытой формы при успешном запланировании встречи
![](pictures/success.png)

---
            3 - отображение 2-й скрытой формы при перепланировании встречи (отображается при заполнении даты теми же данными и измененной даты встречи)
![](pictures/replan.png)