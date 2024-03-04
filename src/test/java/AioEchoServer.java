import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @author 流沙
 * @date 2024/1/9
 */
public class AioEchoServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress("127.0.0.1", 1192));
        // 异步accept
        serverChannel.accept(null,  new AcceptCompletionHandler(serverChannel));
        Thread.sleep(Integer.MAX_VALUE);
    }

    private static class AcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, Object> {
        private AsynchronousServerSocketChannel serverChannel;

        public AcceptCompletionHandler(AsynchronousServerSocketChannel serverChannel) {
            this.serverChannel = serverChannel;
        }


        @Override
        public void completed(AsynchronousSocketChannel result, Object attachment) {
            // in order to accept other client's connections
            serverChannel.accept(attachment, this);


        }

        @Override
        public void failed(Throwable exc, Object attachment) {
            // log exc exception

        }
    }
}
