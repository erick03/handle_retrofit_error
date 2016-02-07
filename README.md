# Retrofit 2.0 handling errors

I've been working in a personal [Android] application, to connect with the web service I use [Retrofit] 2.0 beta 3, while I was checking the process I found that some errors can't be handle for retrofit for example **status error > 400** . To solved that I did a few changes that will be explained below.

### Installation

For gradle installation:

```sh
compile 'com.squareup.retrofit2:retrofit:2.0.0-beta4'
```

### Steps

I created RestClient that basically is a singleton class for the **retrofit** object.

In **RestClient** is a method to add an **interceptor**, just to send some values in the header.

```sh
 public OkHttpClient getOkHttpClient() {
        RequestInterceptor requestInterceptor = new RequestInterceptor();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build();
        return okHttpClient;
    }
```

Retrofit has a property that will let us know if the call to the service was successful.

```shsh
@Override
public void onResponse(Response<TempError> response) {
    if(response.isSuccess()) {
        /// do something
    } else {
        /// Converter for errores
    }
}
```

To handle and error when the ***status > 400*** , there is a custom class called ***Utils*** inside this class we have a method ***parseError*** that recives in parameter the ***Response<?> response***, this is to convert the response and return our custom error.

```sh
public static TempError parseError(Response<?> response) {
    ///This converter create the base for custom error.
    Converter<ResponseBody, TempError> converter = RestClient.getsInstance().getRetrofit().responseBodyConverter(TempError.class, new Annotation[0]);
    TempError error;
    try {
        error = converter.convert(response.errorBody());
    } catch (IOException e) {
        return new TempError();
    }
    return error;
}
```

And our response methos is working in this way:

```sh
@Override
public void onResponse(Response<TempError> response) {
    if(response.isSuccess()) {
        /// do something
    } else {
        /// Converter for error
        TempError error = Utils.parseError(response).getError();
    }
}
```

Hope this help you, and if you have any question or suggestion let me.


**Free Software, Hell Yeah!**

   [Retrofit]: <http://square.github.io/retrofit/>
   [Android]: <http://developer.android.com/>

   [PlDb]: <https://github.com/joemccann/dillinger/tree/master/plugins/dropbox/README.md>
   [PlGh]:  <https://github.com/joemccann/dillinger/tree/master/plugins/github/README.md>
   [PlGd]: <https://github.com/joemccann/dillinger/tree/master/plugins/googledrive/README.md>
   [PlOd]: <https://github.com/joemccann/dillinger/tree/master/plugins/onedrive/README.md>



