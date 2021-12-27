## Iurii-Radomskii-Mobile

### **Pre-conditions:**

1. Run AVD manager tool. Run android device with installed Chrome browser
2. Open CLI and input `adb devices`
3. Run Appium Server on localhost, port 4723

### **Tests:**

run web tests: `mvn clean test -P web` (runs by default)

run native tests: `mvn clean test -P native`

Tested AVD: Google Pixel


## Iurii-Radomskii-Mobile-CLoud

## **Pre-conditions**
1. Write your project name and token to property file
2. Before android tests, occupy Samsung Galaxy S8 and install EPAMTestApp.apk
2. Before ios tests, occupy iPhone 8 and install EPAMTestApp.ipa


## **Test running**

run web tests: `mvn clean test -P android-cloud-web` (runs by default)

run native tests: `mvn clean test -P android-cloud-native`

run web tests: `mvn clean test -P ios-cloud-web`

run native tests: `mvn clean test -P ios-cloud-native`

