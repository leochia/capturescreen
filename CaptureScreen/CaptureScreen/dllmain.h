// dllmain.h : Declaration of module class.

class CCaptureScreenModule : public CAtlDllModuleT< CCaptureScreenModule >
{
public :
	DECLARE_LIBID(LIBID_CaptureScreenLib)
	DECLARE_REGISTRY_APPID_RESOURCEID(IDR_CAPTURESCREEN, "{78A3906E-AC20-414F-B669-B01F0F168CB8}")
};

extern class CCaptureScreenModule _AtlModule;
