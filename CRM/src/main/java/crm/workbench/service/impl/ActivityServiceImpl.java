package crm.workbench.service.impl;

import crm.utils.SqlSessionUtil;
import crm.workbench.dao.ActivityDao;
import crm.workbench.service.ActivityService;

public class ActivityServiceImpl implements ActivityService {
    ActivityDao activityDao= SqlSessionUtil.getSqlSession().getMapper(ActivityDao.class);
}
