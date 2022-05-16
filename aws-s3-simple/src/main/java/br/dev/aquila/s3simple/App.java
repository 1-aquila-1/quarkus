package br.dev.aquila.s3simple;

import java.io.FileInputStream;
import java.util.List;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;

public class App {

    private final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.SA_EAST_1).build();
    private final String bucketName = "myenglish7/palavra";

    public void gerarURL() {
        var url = s3.getUrl(bucketName, "frase/frase1.mp3");
        System.out.println(url.toString());
    }

    public void listarBuckets() {
        var buckets = s3.listBuckets();
        for (Bucket b : buckets) {
            System.out.println("* " + b.getName());
        }
    }

    public void listaObjetoBucket() {
        System.out.format("Objects in S3 bucket %s:\n", bucketName);
        ListObjectsV2Result result = s3.listObjectsV2(bucketName);
        List<S3ObjectSummary> objects = result.getObjectSummaries();
        for (S3ObjectSummary os : objects) {
            System.out.println("* " + os.getKey());
        }
    }

    public void addObjeto() throws Exception{
        var path = "C:\\Workspaces\\ingles-audio\\alfaberto-fonetico-exemplo\\p\\pen.mp3";
        var metadata = new ObjectMetadata();
        metadata.setContentType("audio/mpeg");
        var putObjectRequest = new PutObjectRequest(bucketName, "pen.mp3", new FileInputStream(path), metadata);
        s3.putObject(putObjectRequest);
        System.out.println("Sucesso!!!");
    }

    public static void main(String[] args) throws Exception {
        var app = new App();
        app.gerarURL();
    }
}
