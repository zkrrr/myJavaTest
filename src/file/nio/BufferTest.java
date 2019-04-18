package file.nio;


import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class BufferTest
{
	public static void main(String[] args)
	{
		// 创建Buffer
		CharBuffer buff = CharBuffer.allocate(8);//普通内存适合多次申请 做数据的交互
		ByteBuffer b=ByteBuffer.allocateDirect(10);//直接内存适合一次申请 重复使用
//		CharBuffer wb=CharBuffer.wrap(new char[8]);//把char数组转换为charBuffer
		System.out.println("capacity : "	+ buff.capacity());
		System.out.println("limit: " + buff.limit());
		System.out.println("position: " + buff.position());
		// 放入元素
		buff.put('a');
		buff.put('b');
        buff.mark();//打断点
		buff.put('c');
        buff.reset();//指针回到断点
        buff.put('d');

		System.out.println("加入三个元素后，position = "
			+ buff.position());
		// 调用flip()方法
		buff.flip();
		System.out.println("执行flip()后，limit = " + buff.limit());
		System.out.println("position = " + buff.position());
		// 取出第一个元素
		System.out.println("第一个元素(position=0)：" + buff.get());
		System.out.println("取出一个元素后，position = "
			+ buff.position());


		// 调用clear方法
		buff.clear();//buff.rewind();
		System.out.println("执行clear()后，limit = " + buff.limit());
		System.out.println("执行clear()后，position = "
			+ buff.position());
		System.out.println("执行clear()后，缓冲区内容并没有被清除："
			+ "第三个元素为：" +  buff.get(2));
		System.out.println("执行绝对读取后，position = "
			+ buff.position());
	}
}