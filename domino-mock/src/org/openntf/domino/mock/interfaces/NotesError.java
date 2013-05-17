package org.openntf.domino.mock.interfaces;

/**
 * @author Sven Dreher
 * 
 */
public interface NotesError {
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ERROR = 4000;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SYS_OUT_OF_MEMORY = 4001;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SYS_LOAD_OUT_OF_MEM = 4002;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SYS_FILE_NOT_FOUND = 4003;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SYS_DICT_NOT_ON_PATH = 4004;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ERROR2 = 4005;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SYS_RESOURCE_NOT_FOUND = 4008;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SYS_LOADING_RESOURCE = 4009;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SYS_LOCKING_RESOURCE = 4010;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SYS_FREEING_RESOURCE = 4011;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SYS_NOSUCH_RESOURCE = 4012;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SYS_WARNING_TITLE = 4016;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_MAIL_COPEN_FAILED = 4026;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_MAIL_PAOPEN_FAILED = 4027;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_MAIL_LAOPEN_FAILED = 4028;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_MAIL_VIM_MESSAGE = 4029;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_MAIL_CANT_CREATE = 4030;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_MAIL_UNKNOWN_PROP = 4031;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_MAIL_INVALID_MSG = 4032;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_MAIL_NOPUBLIC_GRP = 4033;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_MAIL_NOPRIVATE_GRP = 4034;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_MAIL_GRPCREATE_FAILED = 4035;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_MAIL_GROUP_DELETED = 4036;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_MAIL_NAME_REQUIRED = 4037;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_FAILURE = 4038;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOSUCH_VIEW = 4039;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOFTINDEX = 4040;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DBCREATE_FAILED = 4041;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DBDELETE_FAILED = 4042;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DBOPEN_FAILED = 4043;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_FORMULA = 4044;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_DATE = 4045;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_COPY_FAILED = 4046;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_VIEWOPEN_FAILED = 4047;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOTEDEL_FAILED = 4048;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NEXTITEM_FAILED = 4049;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_FINDITEM_FAILED = 4050;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_MODLOAD_FAILED = 4051;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_PROCFIND_FAILED = 4052;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RTWRITE_FAILED = 4053;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RTCONVERT_FAILED = 4054;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_FTSRCH_FAILED = 4055;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_QUERY_FAILED = 4056;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DOCSEARCH_FAILED = 4057;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ITEMCOPY_FAILED = 4058;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CREATENOTE_FAILED = 4059;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DBNOACCESS = 4060;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_UNAME_LOOKUP = 4061;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SESOPEN_FAILED = 4062;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DATABASE_NOTOPEN = 4063;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SESSION_DATECONV = 4064;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SESSION_VALNOTSUPP = 4065;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANT_GETNTH = 4066;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ATTACH_FAILED = 4067;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DETACH_FAILED = 4068;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_EXTRACT_FAILED = 4069;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DIRSEARCH_FAILED = 4070;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_BAD_INDEX = 4071;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOSUCH_DIRECTORY = 4072;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CDTEXTCREATE_FAILED = 4073;
	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CDASSIM_FAILED = 4074;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOT_RT_ITEM = 4075;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_FORMCOMP_FAILED = 4076;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_FORMEVAL_FAILED = 4077;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ITEMCREATE_FAILED = 4078;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DECRYPT_FAILED = 4079;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOTLOCAL_IDX = 4080;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_FTIDX_FAILED = 4081;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOTEOPEN_FAILED = 4082;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RENDER_FAILED = 4083;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_FILENOTFOUND = 4084;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_UNKNOWN_TYPE = 4085;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_FILEOPEN_FAILED = 4086;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_FILEWRITE_FAILED = 4087;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DATE_NOTSET = 4088;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NODBNAME = 4089;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_TEMPLCOPY_FAILED = 4090;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_BAD_UNID = 4091;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_UNAME_REQ = 4092;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_GETACL_FAILED = 4093;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ACLENTRY_FAILED = 4094;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ACL_INVALID = 4095;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_QUERYACL_FAILED = 4096;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_REFRESH_FAILED = 4097;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_OLEPKG_FAILED = 4098;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_TMPFILE_FAILED = 4099;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_READFILE_FAILED = 4100;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RTRENDER_FAILED = 4101;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_WRONG_CLASS = 4102;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_ID = 4103;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_AGENT = 4104;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_VIEWCLONE_FAILED = 4105;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOVIEWNAME = 4106;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NEWSGROUPDB_FAILED = 4107;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NONEWSGROUPNAME = 4108;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ARC_NOT_ENABLED = 4109;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ARC_INCORRECT_PROFILE = 4110;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ARC_REQ_SRC_ACCESS = 4111;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ARC_REQ_ARC_ACCESS = 4112;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ARC_INCORRECT_SVR = 4113;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ARC_ARCFILE_NOT_ON_SVR = 4114;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ARC_FAILED = 4115;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ARC_SERVER_ARCHIVING = 4116;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ARC_SETTINGS_SIGNATURE = 4117;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ARC_REQ_SRC_USER_ACCESS = 4118;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ARC_REQ_ARC_USER_ACCESS = 4119;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ARC_PROHIBITED = 4120;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_LOG_DBOPEN_FAILED = 4135;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_LOG_FOPEN_FAILED = 4136;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_LOG_CDCREATE_FAILED = 4137;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_LOG_MAILLOG_FAILED = 4138;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_MEM_HVPOOLFULL = 4139;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_COPYACL_FAILED = 4150;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DOC_NOTINVIEW = 4151;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOFTQUERY = 4152;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOITEMNAME = 4153;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOTEUPDATE_FAILED = 4154;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOTELOCATE_FAILED = 4155;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_VIEWDEL_FAILED = 4156;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_LOG_CONSTRUCT_FAILED = 4157;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SEM_ALLOC_FAILED = 4158;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_LOOKUP_FAILED = 4159;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SEND_FAILED = 4160;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NCREATE_FAILED = 4161;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_MACRO_IDTBL_FAILED = 4162;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_MACRO_RUN_FAILED = 4163;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DBOPEN_NOTLOCAL = 4164;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SIGN_NOPERM = 4165;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ENCRYPT_NOPERM = 4166;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ENCRYPT_FAILED = 4167;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOSENDTO = 4168;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_LOG_EVENTPUT_FAILED = 4169;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_LOG_INVALID_EVTYPE = 4170;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_LOG_INVALID_SEVERITY = 4171;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NO_NEWSLETTERDOCS = 4172;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_MAILDBOPEN_FAILED = 4173;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NEWSLETTER_FAILED = 4174;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DFLT_VID_FAILED = 4175;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_KEYFIND_FAILED = 4176;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RTTEXT_FAILED = 4177;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RTDOCLINK_FAILED = 4178;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOPERM_DISKIO = 4179;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOPERM_SIGN = 4180;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOPERM_ENCRYPT = 4181;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOPERM_ENVIRON = 4182;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOPERM_ANY = 4183;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOSERV_DB = 4184;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_DB = 4185;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_CREDEL = 4186;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_DOC = 4187;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DBS_MUST_MATCH = 4188;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RESPONSE_FAILED = 4189;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOLISTS = 4190;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CONTAINS_FAILED = 4191;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_MUSTBE_STRING = 4192;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DESVIEW_FAILED = 4193;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ITEMARR_FAILED = 4194;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SRVSEARCH_FAILED = 4195;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_UNKNOWN_SRCHTYPE = 4196;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_MUSTCALL_FIRSTDB = 4197;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ALLDOCS_FAILED = 4198;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ITYPENOT_TEXT = 4199;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_ITYPE = 4200;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOSUCH_FOLDER = 4201;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ADDRBOOK_FAILED = 4202;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOTCONTEXT_DB = 4203;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_LTDACCESS_FAILED = 4204;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_LTDUPDATE_FAILED = 4205;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_BADVIEW_VERSION = 4206;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NEED_ADT = 4207;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ACLWRITE_FAILED = 4208;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RENAME_FAILED = 4209;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOSUCH_ROLENAME = 4210;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_PRIVNAME_FAILED = 4211;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_READPRIV_FAILED = 4212;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DELPRIV_FAILED = 4213;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DELENTRY_FAILED = 4214;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOSERV_EVENTS = 4215;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_ACLENTRYNAME = 4216;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ENTRYNAME_FAILED = 4217;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOTLOCAL_REPL = 4218;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_REPL_FAILED = 4219;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOTLOCAL_COMPACT = 4220;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_COMPACT_FAILED = 4221;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_TIMEADJUST_FAILED = 4222;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOSUCH_EMBED = 4223;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOSUCH_EOFILE = 4224;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOSUCH_PATH = 4225;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_EMBEDARR_FAILED = 4226;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOADDRS_FOUND = 4227;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DUP_ROLENAME = 4228;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANTCREATE_FOLDER = 4229;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOTERENDER_FAILED = 4230;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOFROMFIELD = 4231;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_TEXTLIST_FAILED = 4232;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOTA_DOCUMENT = 4233;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_VALIDATE_FAILED = 4234;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ABSTRACT_BUFFER = 4235;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ABSTRACTING_TEXT = 4236;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DESAGENT_FAILED = 4237;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_MIXED_ARRAY = 4238;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_DOCLINK = 4239;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_TEXTLIST_BAD_INPUT = 4240;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANTREMOVE = 4241;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANTENCRYPT = 4242;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANTCLOSEDB = 4243;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANTRUN_OLEOBJ = 4244;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANTSHOW_OLEOBJ = 4245;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOEMBEDDED_OBJ = 4246;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOSUCH_EMBEDCLASS = 4247;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANTGET_DBSUMMARY = 4248;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANTCOPY_ITEMTYPE = 4249;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NEED_DB = 4250;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NEED_NOTE = 4251;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANT_LINK_OLE1 = 4252;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ROLENAME_TOOBIG = 4253;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_EOARRAY_FAILED = 4254;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ATTACHINFO_FAILED = 4255;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_QUOTAINFO_FAILED = 4256;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DOCNOTSAVED = 4257;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ACLNEXT_INVALID = 4258;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOTAFILE = 4259;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANTFIND_ATTACHMENT = 4260;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOSUCH_VERB = 4261;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DOVERB_FAILED = 4262;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_ADTTYPE = 4263;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_FTQUERY_FAILED = 4264;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOSUCH_DBID = 4265;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_OPENBYRID_FAILED = 4266;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_BAD_UNPROCFT = 4267;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_AGENT_NO_RECURSION = 4268;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANTGET_MAILSERVER = 4269;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_BAD_NOTEID = 4270;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DBSECURITY = 4271;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DELETE_AGENT = 4272;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RUN_AGENT = 4273;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOSUCH_DOCINDEX = 4274;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_BAD_SOURCE_CLASS = 4275;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANT_CHANGE_DEFACL = 4276;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_LINKNOCLASS = 4277;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANTDO_ARRAYOFARRAY = 4278;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SESSION_CLOSED = 4279;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANTOPEN_URLDB = 4280;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NEED_URL = 4281;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_URL = 4282;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_URLHEADER = 4283;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOSUCH_URLHEADER = 4284;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOUNPROC_DOCS = 4285;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_EMBED_FAILED = 4286;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NODEL_CURRENTDB = 4287;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_TIMEEXPR = 4288;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RECURSIVE_RENDER = 4289;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_ITEM = 4290;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOMOVETO_PRIV1STUSE = 4291;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SAMESRV_REPLICA = 4292;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANT_SIGN = 4293;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NO_MATCH = 4294;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_AMBIGUOUS_MATCH = 4295;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DBALREADY_OPEN = 4296;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_OLE_NOTAVAIL = 4297;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ARRAY_NOGOOD = 4298;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_REGARG_NOTGIVEN = 4299;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_MISSING_CERTID = 4300;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOCERT_CTX = 4301;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_REGFAILED = 4302;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SRVREGFAILED = 4303;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CERTREGFAILED = 4304;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_XCERTFAILED = 4305;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RECERTFAILED = 4306;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOSUCH_BOOL = 4307;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANTSWITCH_ID = 4308;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOSUCH_MAILPATH = 4309;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_BAD_IDFILE = 4310;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANTADD_USER = 4311;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANTADD_SERV = 4312;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANTADD_CERT = 4313;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOCURRENT_AGENT = 4314;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_AGENTLOG_FAILED = 4315;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOSUCH_CERTIDTYPE = 4316;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOCURRENT_FTRESULT = 4317;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_IDTBL_FAILED = 4318;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_PROF_ARG_MISSING = 4319;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOSUCH_PROFILE = 4320;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_PROFUPDATE_FAILED = 4321;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_PROFDELETE_FAILED = 4322;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOSUCH_ARG = 4323;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_WRONG_UNID_LEN = 4324;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DESFORM_FAILED = 4325;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_FORMDEL_FAILED = 4326;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOCLOSE_CURRDB = 4327;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_FREETIME_FAILED = 4328;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_UNIFORM_FAILED = 4329;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_GETOPTION_FAILED = 4330;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_MARKREAD_FAILED = 4331;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_MARKUNREAD_FAILED = 4332;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_MULTIDB_FAILED = 4333;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ADDPROF_FAILED = 4334;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ULOOKUP_FAILED = 4335;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_OBJECT = 4336;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_STAMP_FAILED = 4337;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_BAD_ORGUNIT = 4338;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_BAD_FTSORT = 4339;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOTCONTEXT_COLLEC = 4340;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ECLACCESS_FAILED = 4341;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_W32DOM_FAILED = 4342;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_W32DOM_NOFIRSTUSER = 4343;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_W32DOM_BADPLATFORM = 4344;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_W32DOM_BADNETAPI32 = 4345;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_W32DOM_DOMAIN_CONTROLLER = 4346;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_TOOMANY_SORT_KEYS = 4347;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_BAD_KEYTYPE = 4348;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANT_SELF_ASSIMILATE = 4349;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANT_SELF_COPY = 4350;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_POP3_FAILED = 4351;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ARRCREATE_FAILED = 4352;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_AGSAVE_FAILED = 4353;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANTREMOVE_AGC = 4354;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANTENCRYPT_AGC = 4355;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RTSTYLE_CREATEFAILED = 4356;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RTSTYLE_APPENDFAILED = 4357;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RTSTYLE_BADFONT = 4358;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NO_CONTEXTDB = 4359;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NULL_APPENDLIST = 4360;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOSUCH_JAVA_TYPE = 4361;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_JARRAY = 4362;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RTSTYLE_BADBOOL = 4363;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RTSTYLE_BADFONTSIZE = 4364;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RTSTYLE_BADCOLOR = 4365;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RTSTYLE_BADEFFECT = 4366;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOTREMOTE_DB = 4367;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RTITEM_EXISTS = 4368;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOFORM = 4369;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOTA_VECTOR = 4370;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SERVER_SWITCH = 4371;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DBDIR_THREAD = 4372;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ACL_CONSTRUCTOR_FAILED = 4380;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ACL_INVALID_TYPE = 4381;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_TIMEZONE = 4383;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_VIEW_STATS = 4384;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_VIEW_ENTRY_READ = 4385;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DBFOLDERREFS_NOT_SUPPORTED = 4386;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DBFOLDERREFS_NOT_ENABLED = 4387;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_VE_NO_SEPARATOR = 4388;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_STRING_TOO_LONG = 4389;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_VIEW_FMT_READ = 4390;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_VIEW_INVALID_COLUMN = 4396;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NO_COLLECTION = 4373;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOT_IN_SESSION = 4374;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_NAME = 4375;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DELETED = 4376;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOT_LOCAL = 4377;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_RANGE = 4378;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_OBJECT_NOT_FOUND = 4379;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ITEM_CONVERT = 4382;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_VIEW_BAD_ENTRY = 4391;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_VIEWNAV_BAD_MAX = 4392;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_VIEWNAV_BAD_POS = 4393;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_VIEWNAV_BAD_PARENT = 4394;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOT_IMPLEMENTED = 4395;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RTPSTYLE_APPENDFAILED = 4397;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RTPSTYLE_TOOMANYTABS = 4398;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RTPSTYLE_OUTOFRANGE = 4399;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RTPSTYLE_BADALIGN = 4400;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RTPSTYLE_BADSPACING = 4401;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RTPSTYLE_BADPAGINATE = 4402;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ACL_MISSING = 4403;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SESSION_MISSING = 4404;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DATABASE_MISSING = 4405;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DOCUMENT_MISSING = 4406;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_VIEW_MISSING = 4407;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_PARENT_MISSING = 4408;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOT_RICHTEXT = 4409;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_PSTYPE_MISSING = 4410;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_REMOVEALL_FAILED = 4411;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ENTRY_NOT_FROM_COLLECTION = 4412;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOTE_NOT_FROM_COLLECTION = 4413;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ADDENTRY_DUP = 4414;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ADDENTRY_FAILED = 4415;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_MACRO_SYNCH_ENABLE_FAILED = 4416;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SYNCH_RUN_AGENT = 4417;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SYNCH_NOOLE = 4418;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RTPSTYLE_BADTABTYPE = 4419;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_GETALLENTRIES_FAILED = 4420;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_EXECUTESETUP_FAILED = 4421;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_MAXDBSIZE_EXCEEDED = 4422;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_NAV = 4423;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SVRACCESS_FAILED = 4425;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOT_IN_VIEW = 4426;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOT_IN_DB = 4427;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_PROP_NOT_AVAIL = 4428;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOT_IN_ACL = 4429;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NO_LOGS_OPEN = 4430;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CACHE_SZ_INVALID = 4431;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_VIEW_ENTRY_REMOVED = 4432;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_VIEW_ENTRY_DELETED = 4433;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DOCUMENT_DELETED = 4434;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SYNCH_INVALIDOP = 4435;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CREATEOUTLINE_FAILED = 4436;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_HTML_GENFAILED = 4437;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CREATE_DOCCOLL_FAILED = 4438;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_EXECUTESETUP_FAILED2 = 4439;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANTUPDATE_FOLDER = 4440;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RTITEM_MISSING = 4441;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NO_AUTHORIZATION = 4442;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NAME_MISSING = 4443;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ITEM_MISSING = 4444;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DATERANGE_MISSING = 4445;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_VIEWENTRY_MISSING = 4446;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_VIEWENTRY_OR_DOC_MISSING = 4447;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_OUTLINE_MISSING = 4448;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DATETIME_MISSING = 4449;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_VNAV_CAT_PARENT = 4450;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_VNAV_CAT_GOTO = 4451;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_SIZE = 4452;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_REGSERVER_NOTSET = 4453;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOT_ATTACHMENT = 4454;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_URL_NOT_RESOLVED = 4455;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_IOR = 4456;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_GETIOR_FAILED = 4457;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_DATESPEC = 4458;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_TIMESPEC = 4459;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANTSAVE_CURRENTAGENT = 4460;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANTDISABLE_MANUALAGENT = 4461;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_BAD_ENTRYDOC = 4462;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_UNINITIALIZED_THREAD = 4463;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALIDATED_OBJECT = 4464;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ACL_ROLE_INVALID = 4465;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ARG_DELETED = 4466;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ACLENTRY_MISSING = 4467;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_DATE_NOARG = 4468;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ADDDOC_DUP = 4469;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_BADDBSIZE = 4470;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_BAD_OUTLINE_ENTRY = 4471;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANTMODIFY_REMOTE_AGENT = 4472;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANT_ADD_CHILD_BEFORE_ENTRY = 4473;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NULL_REF_ENTRY = 4474;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_REF_ENTRY_NOTINOUTLINE = 4475;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_OUTLINE_ADDENTRY_FAILED = 4476;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_OUTLINE_MOVEENTRY_FAILED = 4477;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_OUTLINE_REMOVEENTRY_FAILED = 4478;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_PLACEHOLDER_PARENT = 4479;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_REPLICATION_PRIORITY = 4480;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_OUTLINE_INVALID_PRIVATE_VIEW = 4481;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOT_SUPPORTED = 4482;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NEED_HDRNAME = 4483;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NEED_MIMEENT = 4484;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ITEM_EXISTS = 4485;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_USERNAME_PASSWD = 4486;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_USERNAME = 4487;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SERVER_ACCESS_DENIED = 4488;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NO_SERVER = 4489;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SESSION_NOT_INIT = 4491;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SESSION_IS_INIT = 4492;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_AGENT_SESSION = 4493;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_CREDENTIALS = 4494;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_LTPA = 4495;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANT_GET_THAT = 4496;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ARRAY_MISMATCH = 4497;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RTCTX_POSITION_INVALID = 4498;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RTTABLE_APPENDFAILED = 4499;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RTTBL_MAXROWS = 4500;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RTTBL_MAXCOLS = 4501;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RTTBL_MINSIZE = 4502;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RTCTX_POSITION_UNDEF = 4503;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RTRNG_RESTRICTED_OPERATION = 4504;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RTEDIT_FAILED = 4505;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RTELEM_TYPEUNKNOWN = 4506;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RT_FIRSTFINISHINSERT = 4507;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_METHODNOTAVAILABLE = 4508;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_VALUE = 4509;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DXLEXPORTER_INPUT_OBJECT = 4510;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DXLEXPORTER_OUTPUT_OBJECT = 4511;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ANADMINP_NOSUCH_CAORG = 4512;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ANADMINP_UNKNOWN = 4513;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RTNAV_INVALID_TYPE = 4514;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_TIMEMERGE_FAILED = 4515;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_GETFONT_FAILED = 4516;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DXLIMPORTER_INPUT_OBJECT = 4517;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DXLIMPORTER_OUTPUT_OBJECT = 4518;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_XSLT_INPUT_OBJECT = 4519;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_XSLT_OUTPUT_OBJECT = 4520;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_XSLT_STYLESHEET_OBJECT = 4521;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DXLIMPORTER_FAILED = 4522;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DXLIMPORTER_INVALID_OPTION = 4523;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_XML_PIPING = 4524;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RT_FIRSTFINISHSECTION = 4525;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DB_POLICYNOTFOUND = 4526;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DB_ARCHIVEINFO = 4527;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SS_ALREADYINUSE = 4528;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_FILEREADONLY = 4529;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_FILE_NONAME = 4530;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOTBYTEARRAY = 4531;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NULLSTRING = 4532;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOTHOTSPOTLINK = 4533;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_BADTBLSTYLE = 4534;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ME_ILLEGALXNOTES = 4535;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NON_BODY_MIME = 4536;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOSUCH_MAILSYSTEM = 4537;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOSUCH_MAILOWNERACCESS = 4538;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOSUCH_ROAMINGCLEANUPSETTING = 4539;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_BADMAILFILEACTION = 4540;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SMSDEL_FAILED = 4541;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOSUCH_GROUP = 4542;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SAXPARSER_INPUT_OBJECT = 4543;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SAXPARSER_OUTPUT_OBJECT = 4544;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DOMPARSER_INPUT_OBJECT = 4545;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DOMPARSER_OUTPUT_OBJECT = 4546;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SS_CHARSET_UNKNOWN = 4547;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ATTRIBUTE_NOT_FOUND = 4548;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_XML_OUTPUT_FORMAT = 4549;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_OUTPUT_OBJECT_NOT_SET = 4550;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RTRNG_USESTANDARDNAV = 4551;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_POLICY_DOC_FAILED = 4552;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RTNAV_MUSTBETYPETEXT = 4553;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RTNAV_NOOFFSETWITHAFTER = 4554;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOT_HIER_MAIL_SERVERS = 4555;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SERVER_MUST_BE_R5 = 4556;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NO_CREATE_REPLICA = 4557;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_BAD_REPLICA_LIST = 4558;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_MAIL_NOMOVE_SAMEPATH = 4559;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOSUCH_ROAMINGUSER = 4560;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOT_HIERARCHICAL_SERVER = 4561;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOT_IN_SAME_DOMAIN = 4562;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ROAMING_NOMOVE_SAMEPATH = 4563;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_APPROVAL_REQUEST = 4564;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_PERSON_NOT_FOUND = 4565;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_XMLREFORMATTER_INPUT_OBJECT = 4566;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_XMLREFORMATTER_OUTPUT_OBJECT = 4567;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_FIRST_ARG_NOT_DOMNODE = 4568;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SECOND_ARG_NOT_DOMNODE = 4569;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NULL_DOMNODE = 4570;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_UNSUPPORTED_PLATFORM_OP = 4571;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_FIRST_ARG_NOT_ATTR_NODE = 4572;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_FIXUP_FAILED = 4573;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOTLOCAL_FIXUP = 4574;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_MUST_BE_NOTESDATETIME = 4575;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DOM_OPERATION = 4576;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANTHASH = 4577;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_UNABLETOLOCK = 4578;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANTLOCK_NOTEMODIFIED = 4579;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANTUNLOCK = 4580;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DATATOOBIG = 4581;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DATATYPETOOBIG = 4582;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DATATYPENOMATCH = 4583;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_XMLREFORMATTER_CONNECTION = 4584;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_XMLREFORMATTER_FAILED = 4585;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ACL_ADMINREADERAUTHOR_FAILED = 4586;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ACL_ADMINNAMES_FAILED = 4587;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ADMINSERVER_FAILED = 4588;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOFIXEDSTRINGS = 4589;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_VARIANT_DATATYPE = 4590;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_COMPACT_INVALID_OPTION = 4591;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_COMPACT_UNSUPPORTED_OPTION = 4592;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_BADPWDCHKSETTING = 4593;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANT_SIGN_DATABASE = 4594;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_LOCKED = 4595;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_NAMELIST = 4596;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANTCONNECT_MASTERLOCKDB = 4597;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOMASTERLOCKDB_DOC = 4598;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOMASTERLOCKDB_DESIGN = 4599;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_VALIDATION_OPTION = 4600;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DXLEXPORTER_FAILED = 4601;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DOMPARSER_FAILED = 4602;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SAXPARSER_FAILED = 4603;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_XSLTRANSFORMER_FAILED = 4604;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_EXTENDEDINFO_FAILED = 4605;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOTA_JBOOLEAN = 4606;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ADMINSERVER_EXISTS = 4607;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SSOTOKEN_GEN = 4608;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SSOTOKEN_AUTH = 4609;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SSOCONFIG = 4610;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SSOTOKEN_INV = 4611;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SSOTOKEN_EXP = 4612;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SERVERCONFIG = 4613;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_COOKIE_BADADDR = 4614;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_COOKIE_EXP = 4615;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_COOKIE_INV = 4616;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_PREVIEW_RESTRICTED = 4617;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INCOMPATIBLE_VERSION = 4618;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SS_ALIEN_THREAD_ACCESS = 4619;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SS_TEXTLINE_TOO_LONG = 4620;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SS_INCOMPATIBLE_CHARSETS = 4621;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_DBSIZE = 4622;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOSUCH_DESIGN = 4623;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_EMBED_IN_PROGRESS = 4624;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_EMBED_NOT_STARTED = 4625;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_RESOLVER_RETVAL = 4626;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DB_MARKED_FOR_DELETE = 4627;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOTE_NOT_IN_DATABASE = 4628;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANNOT_SERIALIZE_DOM_TREE = 4629;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NO_CLUSTER_DB = 4630;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NEGATIVE_VALUE = 4631;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_USER_NO_SERVER = 4632;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DELETE_NET_USER_FALIED = 4633;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NULL_SERVER_NAME = 4634;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_VIEW_TEMPLATE = 4635;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ILLEGAL_SERVER_NAME = 4636;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOT_A_DATE_ITEM = 4637;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RTTBL_BADCOLWIDTH = 4638;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_RECEIVEDITEM = 4639;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOTA_JINTEGER = 4640;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DOMOP_INDEX_SIZE = 4641;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DOMOP_XMLSTRING_SIZE = 4642;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DOMOP_HIERARCHY_REQUEST = 4643;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DOMOP_WRONG_DOCUMENT = 4644;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DOMOP_INVALID_CHARACTER = 4645;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DOMOP_NO_DATA_ALLOWED = 4646;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DOMOP_NO_MODIFY_ALLOWED = 4647;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DOMOP_NOT_FOUND = 4648;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DOMOP_NOT_SUPPORTED = 4649;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DOMOP_INUSE_ATTRIBUTE = 4650;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DOMOP_INVALID_STATE = 4651;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DOMOP_SYNTAX = 4652;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DOMOP_INVALID_MODIFICATION = 4653;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DOMOP_NAMESPACE = 4654;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DOMOP_INVALID_ACCESS = 4655;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOSUCH_DBSIGN = 4656;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_FORMEDIT_FAILED = 4657;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ME_DUPLICATEXNOTES_NAME = 4658;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ME_MISSINGXNOTES_NAME = 4659;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NO_OLECONTEXT = 4660;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANTSIGN_BYNAME = 4661;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ADMINSERVER_NEXIST = 4662;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_COMPACT_I_REQ_C = 4663;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_UNDELETENONPOSITIVEVALUE = 4664;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_XML_PROCESS_ERROR = 4665;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_XML_PIPELINE_LOOP_ERROR = 4666;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_STREAM_HAS_BEEN_USED = 4667;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_STREAM_HAS_MIXED_CONTENT = 4668;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_XML_PROCESSOR_CANNOT_BE_USED = 4669;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DB_BADINDEXFREQUENCY = 4672;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_LONG_OVERFLOW = 4673;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_INVALID_CREDEL_TEMPLATE = 4674;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_BADPLCYSETSTYPE = 4675;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_CANTRETNOTEID = 4677;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_STALE_COLLECTION = 4678;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_EXTENDEDACCESS_FAILED = 4679;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_UNIFORM_FAILED_EA = 4680;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOTEIDFIND_FAILED = 4681;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOFIXUP_CURRDB = 4682;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOT_AN_URLDB = 4683;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_RTNAV_USE_FINDSTRING = 4684;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_UNINITIALIZED_STRUCT = 4685;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_UNINITIALIZED_REMOTE_OBJ = 4686;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NEVER_SUPPORTED = 4687;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SS_TRUNCATION_FAILED = 4688;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NEED_STREAM = 4689;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SS_IO_FAILED = 4690;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NO_MEMBERS_REFRESHED = 4691;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SS_NO_LOCAL_STREAM_REPLACE = 4692;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SS_NO_LOCAL_STREAM_CLOSE = 4693;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SS_NO_LOCAL_STREAM_OPEN = 4694;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_SS_MAX_SPACE_EXCEEDED = 4695;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DOCUMENTCOLLECTION_MISSING = 4696;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOTECOLLECTION_MISSING = 4697;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOSUCH_DBGETMODDOCS = 4698;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_BEP_CLASS = 4699;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_BEP_METHOD = 4700;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_BEP_OPERATION = 4701;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_BEP_CALLS = 4702;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_BEP_TIME = 4703;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_BEP_MEASUREDTIME = 4704;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_BEP_METHODSPROFILED = 4705;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_BEP_MILLISECONDS = 4706;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_BEP_AGENTEXECUTIONTIME = 4707;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_BEP_PROFILE = 4708;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_AP_CFA_NOADMSRV = 4709;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_MAX_THREADSESSIONS = 4710;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_TOOMANY_IN_DIR = 4711;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_BUSYTIME_FAILED = 4712;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_UNREAD_USERNAME = 4713;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_UNREAD_READ = 4714;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_UNREAD_WRITE = 4715;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_DEFAULTVIEW = 4716;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOSINGLES = 4717;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_LAST_ERROR = 4717;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_FOLDERREFS_NOT_SUPPORTED_BY_DB = 4386;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_VIEWNAV_BAD_ENTRY = 4391;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_PSTYLE_MISSING = 4410;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_MACRO_SNM_ENABLE_FAILED = 4416;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_ERR_NOTES_SYNCH_INVALIDOP = 4435;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_NOT_RESOLVED = 4455;

	/**
	 * {@value}
	 */
	public static final int NOTES_ERR_OUTLINE_INVALID_PLACEHOLDER_PARENT = 4479;

	/**
	 * Returns the errors text for the given errors number
	 * 
	 * @param errorNumber
	 *            The error number
	 * @return The error text
	 */
	public abstract String getErrorString(int errorNumber);
}
