<p>Додаток зберігає запити з браузерів chrome, mozilla, samsung - за основу взято Accessibility service - через нього проходить парсінг юаю браузера зі строкою url за приклад роботи з хромом</p>
<p><a href="https://github.com/Ksnk-dm/HistoryBrowser/blob/master/data/src/main/java/com/example/data/sensor/browser/ChromeBrowserAccessibilitySensorImpl.kt">ChromeBrowserAccessibilitySensorImpl</a> - де VIEW_ID ідентифікатор елементу</p>
<p>Для початку роботи необхідно ввімкнути сервіс - або через налаштування або через саму апку (кнопка праворучь вгорі перекине на налаштування акссесабіліті)</p>
<p>Витратив достатньо часу на ресерч як це взагалі реалізувати спочатку пробував через vpn сервіс але там вдалось отримати тільки на який сайт йде запит без детальної лінки, тому вирішив за основу взяти Accessibility.</p>
<p><br/>Проект зроблено багатомодульним для зручності підтримки та масштабування. Основні модулі:<br/>feature<br/>domain<br/>data <br/>root</p>
<p>Можливі проблеми в роботі:</p>
<p>- Для уникнення вигрузки сервісу необхідно в налаштуваннях акуму виставити unrestricted на додаток</p>
<p>- Запиуються дублі під час парсингу - нічого не робив з ними, але можливо перевірку на унікальність зробити і тд для уникнення їх</p>
<p>- В самсунг браузері строка з повним юрл скрита і відображає тільки домен - збереження проходить тільки коли юзер натисне та розгорне строку</p>
<p>Ліби які використовув:</p>
<div>
<pre>com.google.dagger:dagger - старий добрий дагер - так можно використовувати по типу koin але даггер дуже зручний в багатомодульних додатках</pre>
<div>
<pre>com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.5.9 - зручна ліба для роботи з viewBinding</pre>
</div>
<div>
<pre>io.reactivex.rxjava2 - rx для багатопоточності<br/><br/></pre>
<div>
<pre>com.jakewharton.timber:timber:5.0.1 - логуввання</pre>
</div>
</div>
<pre><br/><br/></pre>
</div>
