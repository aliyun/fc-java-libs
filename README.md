fc-java-libs
=======

[![maven version][mvn-image]][mvn-url]
[![build status][travis-image]][travis-url]

[mvn-image]: https://img.shields.io/maven-central/v/com.aliyun/aliyun-java-sdk-fc.svg?style=flat-square
[mvn-url]: http://search.maven.org/#search%7Cga%7C1%7Caliyun-java-sdk-fc
[travis-image]: https://img.shields.io/travis/aliyun/fc-java-sdk/master.svg?style=flat-square
[travis-url]: https://travis-ci.org/aliyun/fc-java-sdk.svg?branch=master

## Requirements

- `Java 1.8 and above`

## License

[APACHE2.0](LICENSE)


## Example

Here is a simple Java function that just echo the input with request ID

```Java
package aliyun.serverless.test.example;

import com.aliyun.fc.runtime.StreamRequestHandler;
import com.aliyun.fc.runtime.Context;
import com.aliyun.fc.runtime.FunctionComputeLogger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * This handler just echo the input with request ID
 */
public class EchoStreamHandler implements StreamRequestHandler {
    public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
        FunctionComputeLogger logger = context.getLogger();
        logger.debug(String.format("Handle request %s", context.getRequestId()));
        byte[] data = new byte[1024];
        output.write(context.getRequestId().getBytes());
        output.write(System.lineSeparator().getBytes());
        int nRead;
        while ((nRead = input.read(data, 0, data.length)) != -1) {
            output.write(data, 0, nRead);
            logger.debug(String.format("handler received data %s", new String(data)));
        }
        output.flush();
    }
}
```

