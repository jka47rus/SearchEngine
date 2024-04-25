# Search engine
"Поисковый движек" представляет из себя Spring-приложение
(JAR-файл, запускаемый на любом сервере или компьютере), работающее с локально установленной базой данных MySQL, имеющее простой
веб-интерфейс и API, через который им можно управлять и получать результаты поисковой выдачи по запросу.

Принципы работы поискового движка
1. В конфигурационном файле перед запуском приложения задаются адреса сайтов, по которым движок должен осуществлять поиск.
2. Поисковый движок самостоятельно обходит все страницы заданных сайтов и индексирует их (создавая так называемый индекс)
так, чтобы потом находить наиболее релевантные страницы по любому поисковому запросу.
3. Пользователь присылает запрос через API движка. Запрос — это набор слов, по которым нужно найти страницы сайта.
4. Запрос определённым образом трансформируется в список слов, переведённых в базовую форму. Например, для существительных —
именительный падеж, единственное число.
5. В индексе ищутся страницы, на которых встречаются все эти слова.
6. Результаты поиска ранжируются, сортируются и отдаются пользователю.

## Описание веб-интерфейса
Веб-интерфейс (frontend-составляющая) проекта представляет собой одну веб-страницу с тремя вкладками:
- __Dashboard.__ Эта вкладка открывается по умолчанию. На ней отображается общая статистика по всем сайтам, а также детальная
статистика и статус по каждому из сайтов (статистика, получаемая по запросу /api/statistics):
![dashboard](dashboard.jpg)
- __Management.__ На этой вкладке находятся инструменты управления поисковым движком — запуск и остановка полной индексации
(переиндексации), а также возможность добавить (обновить) отдельную страницу по ссылке:
![dashboard](management.jpg)
- __Search.__ Эта страница предназначена для тестирования поискового движка. На ней находится поле поиска, выпадающий список с выбором сайта для поиска, а при нажатии на кнопку «Найти» выводятся
результаты поиска (по API-запросу /api/search).
![dashboard](search.jpg)
Вся информация на вкладки подгружается путём запросов к API вашего
приложения. При нажатии кнопок также отправляются запросы.
