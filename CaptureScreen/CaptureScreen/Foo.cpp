// Foo.cpp : Implementation of CFoo

#include "stdafx.h"
#include <atlimage.h>
#include < atlenc.h>
#include <gdiplus.h>
#include <comutil.h>
#include "Foo.h"

#pragma comment(lib,"comsuppw.lib")

#pragma comment(lib,"kernel32.lib")

// CFoo


STDMETHODIMP CFoo::PicValue(BSTR* na)
{
       // TODO: Add your implementation code here
HDC hdcSrc = GetDC(NULL);
    int nBitPerPixel = GetDeviceCaps(hdcSrc, BITSPIXEL);
    int nWidth = GetDeviceCaps(hdcSrc, HORZRES);
    int nHeight = GetDeviceCaps(hdcSrc, VERTRES);
    CImage image;
    image.Create(nWidth, nHeight, nBitPerPixel);
    BitBlt(image.GetDC(), 0, 0, nWidth, nHeight, hdcSrc, 0, 0, SRCCOPY);
    ReleaseDC(NULL, hdcSrc);
    image.ReleaseDC();
        IStream * pStmImage   = NULL ;
    HGLOBAL   hMemBmp = GlobalAlloc (GMEM_MOVEABLE ,0);// 分配一块默认堆，返回一块内存对象句柄
    if (hMemBmp == NULL )
    return  S_OK;
    CreateStreamOnHGlobal (hMemBmp , FALSE , &pStmImage ); // 将内存区作为流的起始 
    if (pStmImage == NULL ){
        GlobalFree (hMemBmp );
        return S_OK ;
   }
    image.Save(pStmImage, Gdiplus::ImageFormatJPEG);
    BYTE * pbyBmp = (BYTE *)GlobalLock (hMemBmp );// 把一个内存对象句柄转化成一个指针
    int   msize = GlobalSize (hMemBmp );
        BYTE* lpBuf=new BYTE[msize];// 申请数据空间
         memcpy (lpBuf ,pbyBmp ,msize );  // 得到文件的数据
        int nSrcLen = strlen((char*)lpBuf);
        int nDestLen = Base64EncodeGetRequiredLength(msize);
          int* mm=&nDestLen;
        LPSTR lpszDest = new char[nDestLen];
        Base64Encode((BYTE*)lpBuf, msize, lpszDest, mm);  
         *na=_com_util::ConvertStringToBSTR(lpszDest);
         // 释放流
    if (pStmImage != NULL ){
          pStmImage -> Release ();
          pStmImage = NULL ;
    }
    // 释放空间
if ( lpBuf != NULL )
{   
    delete []lpBuf ;
    lpBuf = NULL ;
}
// 释放堆空间
if (hMemBmp != NULL )
{
    GlobalUnlock (hMemBmp );
    GlobalFree (hMemBmp );
    hMemBmp = NULL ;
}
if (image )
{
    image .Detach ();
    image .Destroy ();
}

        return S_OK;
}
