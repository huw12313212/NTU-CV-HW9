package cv;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class cv {

    static Random random = new Random();
	public static void main(String[] args) throws IOException {

		 String fileName = "./assets/lena.im";
		 int headerLength = 172;
		 int imageWidth = 512;
		 int imageHeight = 512;
		 
		 
		 Kernel RobertsKernelR1 = new Kernel(new float[][]{
				  { -1,0},
				  {0,1},
				},0,0);
		 
		 Kernel RobertsKernelR2 = new Kernel(new float[][]{
				  { 0,-1},
				  {1,0},
				},0,0);
		 
		 Kernel PrewittKernelP1= new Kernel(new float[][]{
				  { -1 ,-1 , -1},
				  {0,0,0},
				  {1,1,1},
				},1,1);
		 
		 Kernel PrewittKernelP2= new Kernel(new float[][]{
				  { -1 ,0 ,1},
				  {-1,0,1},
				  {-1,0,1},
				},1,1);
		 
		 
		 Kernel SobelKernelS1= new Kernel(new float[][]{
				  { -1 ,-2 , -1},
				  {0,0,0},
				  {1,2,1},
				},1,1);
		 
		 Kernel SobelKernelS2= new Kernel(new float[][]{
				  { -1 ,0 ,1},
				  {-2,0,2},
				  {-1,0,1},
				},1,1);
		 
		 Kernel FreiAndChenG1= new Kernel(new float[][]{
				  { -1 ,- (float)Math.sqrt(2) , -1},
				  {0,0,0},
				  {1,(float)Math.sqrt(2),1},
				},1,1);
		 
		 Kernel FreiAndChenG2= new Kernel(new float[][]{
				  { -1 ,0 ,1},
				  {-(float)Math.sqrt(2),0,(float)Math.sqrt(2)},
				  {-1,0,1},
				},1,1);
		 
		 Kernel KirschK0 =  new Kernel(new float[][]{
				  {-3,-3, 5},
				  {-3, 0, 5},
				  {-3,-3, 5},
				},1,1);
		 
		 Kernel KirschK1 =  new Kernel(new float[][]{
				  {-3, 5, 5},
				  {-3, 0, 5},
				  {-3,-3,-3},
				},1,1);
		 
		 Kernel KirschK2 =  new Kernel(new float[][]{
				  { 5, 5, 5},
				  {-3, 0,-3},
				  {-3,-3,-3},
				},1,1);
		 
		 Kernel KirschK3 =  new Kernel(new float[][]{
				  { 5, 5,-3},
				  { 5, 0,-3},
				  {-3,-3,-3},
				},1,1);
		 
		 Kernel KirschK4 =  new Kernel(new float[][]{
				  { 5,-3,-3},
				  { 5, 0,-3},
				  { 5,-3,-3},
				},1,1);
		 
		 Kernel KirschK5 =  new Kernel(new float[][]{
				  {-3,-3,-3},
				  { 5, 0,-3},
				  { 5, 5,-3},
				},1,1);
		 
		 Kernel KirschK6 =  new Kernel(new float[][]{
				  {-3,-3,-3},
				  {-3, 0,-3},
				  { 5, 5, 5},
				},1,1);
		 
		 Kernel KirschK7 =  new Kernel(new float[][]{
				  {-3,-3,-3},
				  {-3, 0, 5},
				  {-3, 5, 5},
				},1,1);
		 
		 Kernel r0 =  new Kernel(new float[][]{
				  {-1, 0, 1},
				  {-2, 0, 2},
				  {-1, 0, 1},
				},1,1);
		 
		 Kernel r1 =  new Kernel(new float[][]{
				  { 0, 1, 2},
				  {-1, 0, 1},
				  {-2,-1, 0},
				},1,1);
		 
		 Kernel r2 =  new Kernel(new float[][]{
				  { 1, 2, 1},
				  { 0, 0, 0},
				  {-1,-2,-1},
				},1,1);
		 
		 Kernel r3 =  new Kernel(new float[][]{
				  { 2, 1, 0},
				  { 1, 0,-1},
				  { 0,-1,-2},
				},1,1);
		 
		 Kernel r4 =  new Kernel(new float[][]{
				  { 1, 0,-1},
				  { 2, 0,-2},
				  { 1, 0,-1},
				},1,1);
		 
		 Kernel r5 =  new Kernel(new float[][]{
				  { 0,-1,-2},
				  { 1, 0,-1},
				  { 2, 1, 0},
				},1,1);
		 
		 Kernel r6 =  new Kernel(new float[][]{
				  {-1,-2,-1},
				  { 0, 0, 0},
				  { 1, 2, 1},
				},1,1);
		 
		 Kernel r7 =  new Kernel(new float[][]{
				  {-2,-1, 0},
				  {-1, 0, 1},
				  { 0, 1, 2},
				},1,1);
		 
		 Kernel b0 =  new Kernel(new float[][]{
				  { 100, 100, 100, 100, 100},
				  { 100, 100, 100, 100, 100},
				  {   0,   0,   0,   0,   0},
				  {-100,-100,-100,-100,-100},
				  {-100,-100,-100,-100,-100},
				},2,2);
		 
		 Kernel b1 =  new Kernel(new float[][]{
				  { 100, 100, 100, 100, 100},
				  { 100, 100, 100,  78, -32},
				  { 100,  92,   0, -92,-100},
				  {  32, -78,-100,-100,-100},
				  {-100,-100,-100,-100,-100},
				},2,2);
		 
		 Kernel b2 =  new Kernel(new float[][]{
				  { 100, 100, 100,  32,-100},
				  { 100, 100,  92, -78,-100},
				  { 100, 100,   0,-100,-100},
				  { 100,  78, -92,-100,-100},
				  { 100, -32,-100,-100,-100},
				},2,2);
		 
		 Kernel b3 =  new Kernel(new float[][]{
				  {-100,-100,   0, 100, 100},
				  {-100,-100,   0, 100, 100},
				  {-100,-100,   0, 100, 100},
				  {-100,-100,   0, 100, 100},
				  {-100,-100,   0, 100, 100},
				},2,2);
		 
		 Kernel b4 =  new Kernel(new float[][]{
				  {-100,  32, 100, 100, 100},
				  {-100, -78,  92, 100, 100},
				  {-100,-100,   0, 100, 100},
				  {-100,-100, -92,  78, 100},
				  {-100,-100,-100, -32, 100},
				},2,2);
		 
		 Kernel b5 =  new Kernel(new float[][]{
				  { 100, 100, 100, 100, 100},
				  { -32,  78, 100, 100, 100},
				  {-100, -92,   0,  92, 100},
				  {-100,-100,-100, -78,  32},
				  {-100,-100,-100,-100,-100},
				},2,2);
		 
		 ArrayList<Integer> originImg = GetByteData(fileName);
		 ArrayList<Integer> Roberts = DetectGradientEdge(originImg,headerLength,imageWidth,imageHeight,RobertsKernelR1,RobertsKernelR2,12);
		 ArrayList<Integer> Prewitt = DetectGradientEdge(originImg,headerLength,imageWidth,imageHeight,PrewittKernelP1,PrewittKernelP2,24);
		 ArrayList<Integer> Sobel = DetectGradientEdge(originImg,headerLength,imageWidth,imageHeight,SobelKernelS1,SobelKernelS2,38);
		 ArrayList<Integer> FreiAndChen = DetectGradientEdge(originImg,headerLength,imageWidth,imageHeight,FreiAndChenG1,FreiAndChenG2,30);
		 ArrayList<Integer> Kirsch = DetectGradientEdgeWithMax(originImg,headerLength,imageWidth,imageHeight,new Kernel[]{KirschK0,KirschK1,KirschK2,KirschK3,KirschK4,KirschK5,KirschK6,KirschK7},135);
		 ArrayList<Integer> Robinson = DetectGradientEdgeWithMax(originImg,headerLength,imageWidth,imageHeight,new Kernel[]{r0,r1,r2,r3,r4,r5,r6,r7},43);
		 ArrayList<Integer> Babu = DetectGradientEdgeWithMax(originImg,headerLength,imageWidth,imageHeight,new Kernel[]{b0,b1,b2,b3,b4,b5},12500);
		 
		 WriteOut(Roberts,"./assets/Roberts.im");
		 WriteOut(Prewitt,"./assets/Prewitt.im");
		 WriteOut(Sobel,"./assets/Sobel.im");
		 WriteOut(FreiAndChen,"./assets/FreiAndChen.im");
		 WriteOut(Kirsch,"./assets/Kirsch.im");
		 WriteOut(Robinson,"./assets/Robinson.im");
		 WriteOut(Babu,"./assets/Babu.im");

	}
	
	public static ArrayList<Integer> DetectGradientEdgeWithMax(ArrayList<Integer> origin,int headerLength, int width, int height,Kernel[] kernels,int threshold)
	{
		ArrayList<Integer> results = InitWhite(origin,headerLength,width,height);
		
			for(int y = 0 ; y < height; y++)
			{
				for(int x = 0 ; x < width ; x++)
				{
					float resultValue = CalculateKernel(origin,headerLength,width,height , kernels[0],x,y);
					for(int kernelCounter = 1 ; kernelCounter<kernels.length;kernelCounter++)
					{
						float newKernelResult = CalculateKernel(origin,headerLength,width,height , kernels[kernelCounter],x,y);
						if(newKernelResult>resultValue)resultValue = newKernelResult;
					}
					
					if(resultValue > threshold)
					{
						results.set(headerLength+y*width+x,0);
					}
					else
					{
						results.set(headerLength+y*width+x,255);
					}
				}
			}
		
		return results;
	}
	
	public static ArrayList<Integer> DetectGradientEdge(ArrayList<Integer> origin,int headerLength, int width, int height,Kernel r1,Kernel r2,int threshold)
	{
		ArrayList<Integer> results = InitWhite(origin,headerLength,width,height);
		
		for(int y = 0 ; y < height; y++)
		{
			for(int x = 0 ; x < width ; x++)
			{
				float R1Result = CalculateKernel(origin,headerLength,width,height , r1,x,y);
				float R2Result = CalculateKernel(origin,headerLength,width,height , r2,x,y);
				
				if(Math.sqrt(R1Result*R1Result + R2Result*R2Result) > threshold)
				{
					results.set(headerLength+y*width+x,0);
				}
				else
				{
					results.set(headerLength+y*width+x,255);
				}
			}
		}
		
		return results;
	}
	
	public static float CalculateKernel(ArrayList<Integer> origin,int headerLength, int width, int height,Kernel kernel,int x,int y)
	{
		float sum = 0;
		
		for(int kernelY = 0 ; kernelY< kernel.GetHeight() ; kernelY++ )
		{
			for(int kernelX = 0 ; kernelX < kernel.GetWidth() ; kernelX++)
			{
				int globalX = x + kernelX - kernel.OriginX;
				int globalY = y + kernelY - kernel.OriginY;
				
				if(globalX<0)continue;
				if(globalY<0)continue;
				if(globalX>=width)continue;
				if(globalY>=height)continue;
				
				float result = kernel.Data[kernelY][kernelX] * origin.get(headerLength+globalY*width + globalX);
				
				sum += result;
			}
		}
		
		return sum;
	}

	public static ArrayList<Integer> InitWhite(ArrayList<Integer> origin,int headerLength, int width, int height)
	{
		ArrayList<Integer> results = new ArrayList<Integer>();
		
		for(int i = 0 ; i < headerLength ; i++)
		{
			results.add(origin.get(i));
		}
		
		for(int i = 0 ; i < width ; i ++)
		{
			for(int j = 0 ; j<height ; j++)
			{
				results.add(0);
			}
		}
		
		return results;
	}

	
	public static ArrayList<Integer> GetByteData(String fileName) throws IOException
	{
		 File f = new File(fileName);
		 ArrayList<Integer> bytes = new ArrayList<Integer>();
		
		 //System.out.println("file exist:"+f.exists());
		
		 FileInputStream in = null;	
		 in = new FileInputStream(fileName);
		 
		 int c;
		 while ((c = in.read()) != -1) {
			 bytes.add(c);
        }
		 
		 return bytes;
	}
	
	public static void WriteOut(ArrayList<Integer> data,String name) throws IOException
	{
		File f = new File(name);
		if(f.exists())f.delete();
		FileOutputStream out = null;
		out = new FileOutputStream(name);
		
		for(int i : data)
		{
			out.write((byte)i);
		}
		
		out.flush();
		out.close();
		
	}
	

}
