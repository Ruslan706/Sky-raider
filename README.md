# SKY RAIDER — Android Project

## Как открыть в AndroidIDE (на телефоне)

1. Скачай и распакуй ZIP в память телефона
2. Открой **AndroidIDE**
3. Нажми **Open existing project**
4. Выбери папку `SkyRaider`
5. AndroidIDE скачает Gradle автоматически (~100MB, нужен интернет)
6. После синхронизации нажми ▶ **Run**

## Требования

- AndroidIDE v2.1.4 или новее
- Android 7.0+ на телефоне
- ~500MB свободного места
- Интернет для первой сборки (скачает Gradle + SDK)

## Если AndroidIDE выдаёт ошибку Gradle

Открой `gradle/wrapper/gradle-wrapper.properties`
и убедись что версия совпадает с той что установлена в AndroidIDE.
Обычно это 8.0 или 8.1 — можно проверить в Settings → Gradle.

## Структура проекта

```
SkyRaider/
├── app/src/main/
│   ├── assets/game.html     ← Вся игра здесь
│   ├── java/.../
│   │   ├── MainActivity.kt  ← Точка входа
│   │   └── GameWebView.kt   ← WebView + сохранения
│   └── AndroidManifest.xml
├── build.gradle
└── settings.gradle
```

## Управление в игре

- Тяни пальцем — управление самолётом
- Правый нижний угол — 🚀 Ракета
- Левый нижний угол — 📡 EMI глушилка
- Кнопка назад — возврат в меню

## Android фичи

- ✅ Автосохранение (монеты, уровни, апгрейды)
- ✅ Вибрация при попадании
- ✅ Полноэкранный режим
- ✅ Экран не гаснет
