[![Build status](https://ci.appveyor.com/api/projects/status/a7p58fdmwr38i528?svg=true)](https://ci.appveyor.com/project/Alexander43884/patternstask)


## Автоматический тест формы "Карта с доставкой"
(тест с задержкой до появления скрытой формы)
___

* Создать папку, открыть терминал по адресу папки и инициализировать систему Git `git init`
* Склонировать репозиторий `git clone https://github.com/AlexanderKachalov/WebTestSelenide.git`
* Перейти в директорию artifacts `cd artifacts` и выполнить команду `java -jar app-card-delivery.jar`
* Форма заявки находится по адресу `localhost:9999`
* Вернуться в директорию с проектом `cd /WebTestSelenide`
* Выполнить команду `./gradlew test` (`./gradlew.bat test` для Windows)
* Отчет о выполнении тестов в директории `build/reports/tests/test`
___
* Тестируемая форма (1) и отображение скрытой формы (2) при успешной регистрации:
---
            1 - тестирумая форма
![](Pictures/Pictures_1_Initial_Form.png)

---
            2 - отображение скрытой формы
![](Pictures/Pictures_2_Visible_Hidden_Form.png)