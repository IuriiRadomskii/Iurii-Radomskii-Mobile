## Iurii-Radomskii-Mobile

### **Pre-conditions:**

1. Run AVD manager tool. Run android device with installed Chrome browser
2. Open CLI and input `adb devices`
3. Run Appium Server on localhost, port 4723

### **Tests:**

run web tests: `mvn clean test -P web` (runs by default)

run native tests: `mvn clean test -P native`

Tested AVD: Google Pixel


