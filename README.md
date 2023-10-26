## AppFlags Java Example

Simple app demonstrating how to use AppFlags in a Java application.

For more information, see the docs: https://docs.appflags.io/sdks/java

### To run the example

1. Clone this repository
    ```shell script
    git clone https://github.com/AppFlags/example-java.git
    ```
2. Modify App.java with your SDK key

    * Replace `YOUR_KEY_HERE` with your server key

3. Create a `boolean` feature flag in your account with the key `test`

4. Run App.java

5. The console will output the current state of the `test` feature.

6. Go to the AppFlags dashboard and enable/disable the `test` feature. The console will output the changes in realtime.

  
   