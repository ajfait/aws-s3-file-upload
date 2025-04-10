import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.core.sync.RequestBody;

import java.io.InputStream;
import java.io.IOException;
import java.nio.file.Paths;

public class S3Util {
    private static final String BUCKET = "ajfaitimageupload";

    public static void uploadFile(String fileName, InputStream inputStream) throws IOException {
        S3Client client = S3Client.builder().build();

        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(BUCKET)
                .key(fileName)
                .build();

        client.putObject(request, RequestBody.fromInputStream(inputStream, inputStream.available()));
    }
}
