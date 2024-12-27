package lambda.savefun;

@FunctionalInterface
public interface FileNameTransformer {
	String getFileName(String filePath);
}
