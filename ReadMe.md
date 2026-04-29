

## 🚀 Getting Started

This project is an Appium 2 + Java mobile test automation framework
using UiAutomator2 and Appium Inspector (plugin mode).

---

## ✅ Prerequisites

- Java 17+ (tested with Java 26)
- Apache Maven 3.9+
- Node.js 18+
- Android Studio (with Android SDK)
- An Android Emulator (Pixel / API 33+ recommended)
- IDE: IntelliJ IDEA or VS Code

### Required Environment Variables

Make sure ANDROID_HOME is set and adb works:

```bash
adb devices
```


## 📦 Project Setup

1. **Install dependencies via Maven:**

```bash
mvn clean install
```
2. **Install Appium and Verify:**

```bash
npm install -g appium
```
```bash
appium -v
```
3. **Install UiAutomator2 and Verify:**
```bash
appium driver install uiautomator2
```
```bash
appium driver list
```
4. **Install Appium Inspector (Plugin):**
```bash
appium plugin install inspector
```
5. **Start Appium with Inspector:**
```bash
appium --use-plugins=inspector --allow-cors
```

6. **Open Inspector UI:**
Go to http://localhost:4723/inspector on your browser

7. **Session Parameters:**
- Remote Host: 127.0.0.1 (default)
- Remote Port: 4723 (default)
- Remote Path: / (default)
```bash
{
  "platformName": "Android",
  "appium:automationName": "UiAutomator2",
  "appium:deviceName": "emulator-5554",
  "appium:appPackage": "com.google.android.deskclock",
  "appium:appActivity": "com.android.deskclock.DeskClock",
  "appium:noReset": true
}
```
## 📱 Connecting Inspector to Emulator
Ensure emulator is running:
```bash
adb devices
```
## 🏃 Running Tests
Tests can be run with command:
```bash
mvn clean test -Dgroups=smoke
```